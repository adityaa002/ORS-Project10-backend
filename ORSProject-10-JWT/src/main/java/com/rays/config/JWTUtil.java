package com.rays.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for handling JWT (JSON Web Token) operations such as
 * generation, validation, and claim extraction.
 *
 * <p>
 * This class manually constructs and validates JWT tokens using HMAC SHA-256
 * algorithm without relying on external JWT libraries.
 * </p>
 *
 * <p>
 * It supports:
 * <ul>
 *   <li>Token generation with custom claims</li>
 *   <li>Token validation (signature + expiration + subject)</li>
 *   <li>Extraction of claims like loginId, userId, and role</li>
 * </ul>
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@Component
public class JWTUtil {

	/**
	 * Secret key used for signing JWT
	 */
	@Value("${jwt.secret}")
	private String jwtSecret;

	/**
	 * Token expiration time in milliseconds
	 */
	@Value("${jwt.expiration}")
	private long jwtExpiration; // in milliseconds

	private static final ObjectMapper objectMapper = new ObjectMapper();

	// -------------------------
	// Generate JWT token
	// -------------------------

	/**
	 * Generates a JWT token for a user.
	 *
	 * @param userId  unique user ID
	 * @param loginId user login ID (used as subject)
	 * @param role    user role
	 * @return generated JWT token
	 * @throws Exception if signing or serialization fails
	 */
	public String generateToken(Long userId, String loginId, String role) throws Exception {
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + jwtExpiration;

		// JWT Header
		Map<String, Object> header = new HashMap<>();
		header.put("alg", "HS256");
		header.put("typ", "JWT");

		// JWT Payload (claims)
		Map<String, Object> payload = new HashMap<>();
		payload.put("sub", loginId); // loginId as subject
		payload.put("userId", userId); // numeric user id
		payload.put("role", role); // user role
		payload.put("iat", nowMillis); // issued at
		payload.put("exp", expMillis); // expiration

		String headerBase64 = encodeUrl(objectMapper.writeValueAsString(header));
		String payloadBase64 = encodeUrl(objectMapper.writeValueAsString(payload));
		String signatureBase64 = sign(headerBase64 + "." + payloadBase64, jwtSecret);

		return String.join(".", headerBase64, payloadBase64, signatureBase64);
	}

	// -------------------------
	// Validate JWT token
	// -------------------------

	/**
	 * Validates the given JWT token.
	 *
	 * @param token            JWT token string
	 * @param expectedLoginId expected subject (loginId)
	 * @return true if token is valid
	 * @throws Exception if validation fails (invalid format, signature mismatch,
	 *                   subject mismatch, or token expired)
	 */
	public boolean validateToken(String token, String expectedLoginId) throws Exception {
		String[] parts = token.split("\\.");
		if (parts.length != 3) {
			throw new Exception("Invalid JWT token");
		}

		String payloadJson = decode(parts[1]);
		String tokenLoginId = extractField(payloadJson, "sub");
		String expectedSignature = sign(parts[0] + "." + parts[1], jwtSecret);

		if (!expectedSignature.equals(parts[2])) {
			throw new Exception("JWT signature does not match");
		}

		if (!expectedLoginId.equals(tokenLoginId)) {
			throw new Exception("JWT subject (loginId) does not match");
		}

		if (isTokenExpired(payloadJson)) {
			throw new Exception("JWT token has expired");
		}

		return true;
	}

	// -------------------------
	// Extract claims
	// -------------------------

	/**
	 * Extracts loginId (subject) from token.
	 *
	 * @param token JWT token
	 * @return loginId
	 */
	public String extractLoginId(String token) {
		return extractField(decode(token.split("\\.")[1]), "sub");
	}

	/**
	 * Extracts userId from token.
	 *
	 * @param token JWT token
	 * @return userId
	 */
	public Long extractUserId(String token) {
		return Long.parseLong(extractField(decode(token.split("\\.")[1]), "userId"));
	}

	/**
	 * Extracts role from token.
	 *
	 * @param token JWT token
	 * @return role
	 */
	public String extractRole(String token) {
		return extractField(decode(token.split("\\.")[1]), "role");
	}

	// -------------------------
	// Helper methods
	// -------------------------

	/**
	 * Checks whether token is expired.
	 *
	 * @param payloadJson decoded payload JSON
	 * @return true if expired
	 */
	private boolean isTokenExpired(String payloadJson) {
	    long exp = Long.parseLong(extractField(payloadJson, "exp"));
	    return exp < System.currentTimeMillis();
	}

	/**
	 * Extracts a field value from JSON string.
	 *
	 * @param json  JSON string
	 * @param field field name
	 * @return value as string
	 */
	private String extractField(String json, String field) {
		try {
			Map<String, Object> map = objectMapper.readValue(json, Map.class);
			return String.valueOf(map.get(field));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Generates HMAC SHA-256 signature.
	 *
	 * @param data data to sign
	 * @param key  secret key
	 * @return Base64 URL encoded signature
	 * @throws Exception if signing fails
	 */
	private String sign(String data, String key) throws Exception {
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
		return encodeUrl(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
	}

	/**
	 * Encodes string to Base64 URL format.
	 *
	 * @param data input string
	 * @return encoded string
	 */
	private String encodeUrl(String data) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(data.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * Encodes byte array to Base64 URL format.
	 *
	 * @param data input bytes
	 * @return encoded string
	 */
	private String encodeUrl(byte[] data) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(data);
	}

	/**
	 * Decodes Base64 URL encoded string.
	 *
	 * @param data encoded string
	 * @return decoded string
	 */
	private String decode(String data) {
		return new String(Base64.getUrlDecoder().decode(data), StandardCharsets.UTF_8);
	}
}