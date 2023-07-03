package PolyHealthCenter.security.service;

import PolyHealthCenter.security.payload.LoginDto;
import PolyHealthCenter.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
