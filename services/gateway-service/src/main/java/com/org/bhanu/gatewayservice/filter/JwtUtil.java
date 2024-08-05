package com.org.bhanu.gatewayservice.filter;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	
	public static final String SECRET = "7976cf908d55e3b45ec37eea38a699751917a19cc8e34795bd14265d873b1b2155b0964adf5b23ab1d7753687916c6e6cf2d60b765c6da8100f07a98cbf3102870d231b5b4e8e9698a1057bfb0ba89949dd2da01fb14b60c420e863af9ea69a6b5c35eafecb202dcd2d30e1b097f6391fea0031aba199b92a98b4be302a6f5758932a54cdc426c4d66c208996f26764d44cb431a429e6960bc833a66bcee81a65bdafa4c8c0010a887059a29da9495f794b53442b3adaf2a1714756941fb8cd117b62fcd73983b64df6808baee058beba25bfb6bd243d7417292a410af559fbca184d8873adfc725eab46c33e0b2c939abf948783b98ba12137f375773a9f6b8";

	public void validateToken(final String token) {
		System.out.println(token);
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
	}
	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
