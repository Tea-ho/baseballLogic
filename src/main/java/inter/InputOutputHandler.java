package inter;

public interface InputOutputHandler { // 어떤 상황에서든 입출력 공통으로 사용할 수 있으니 interface [입력 / 출력 / 닫기]
    String getInput();
    void printMessage(String message);
    void closeScanner();
}
