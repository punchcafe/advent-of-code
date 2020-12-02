package dev.punchcafe.aoc.d02;

import lombok.Builder;

@Builder
public class PasswordValidator {
    private PasswordPolicy policy;
    private String password;

    public boolean isValid(){
        int count = 0;
        for(char character : password.toCharArray()){
            if(character == policy.getRestrictedCharacter()){
                count++;
                if(count > policy.getMaxAllowedInstances()){
                    return false;
                }
            }
        }
        return count >= policy.getMinAllowedInstances() && count <= policy.getMaxAllowedInstances();
    }
}
