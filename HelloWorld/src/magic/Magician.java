package magic;

public class Magician {

	public Magician() {}
	public void magic() {
		System.out.println("마술을 시작합니다.");
		System.out.println("마술상자에는 무엇이 있을까요?");
		System.out.println("짜잔 --> "+magicBox.getContents());
	}
	
	//마술상자를 주입 
	private MagicBox magicBox;

	public void setMagicBox(MagicBox magicBox) {
		this.magicBox = magicBox;
	}

	private String magicWords;

	public void setMagicWords(String magicWords) {
		this.magicWords = magicWords;
	}
}
