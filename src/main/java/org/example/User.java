package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
        // as-is : 내부에서 RandomPasswordGenerator를 이용 (강한 결합)
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be : PasswordGenerator 인터페이스를 주입받아 더 낮은 결합도 - 테스트 하기 어려움
        String password = passwordGenerator.generatePassword();

        // 비밀번호는 최소 8자 이상 12자 이하여야 한다. - 테스트 하기 쉬움
        if (password.length() >=8 && password.length() <=12 ) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
