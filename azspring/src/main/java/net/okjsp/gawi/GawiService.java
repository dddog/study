package net.okjsp.gawi;

public class GawiService {

	public static Play play(Game game) {
		Play play = new Play();
		game.setComputerChoice(play.getComputerChoice());
		game.setJudgement(play.judge(game.getChoice(), game.getComputerChoice()));
		String judgement = play.judge(game.getChoice(),
				game.getComputerChoice());
		play.save(game.getChoice(), game.getComputerChoice(), game.getJudgement());
		return play;
	}
}
