import java.util.Random;

public class KnightsTour {

	private final Chezzboard board;

	private final Integer[][] nextPosition = {
			{
					-2, -1 },
			{
					-1, -2 },
			{
					1, -2 },
			{
					2, -1 },
			{
					2, 1 },
			{
					1, 2 },
			{
					-1, 2 },
			{
					-2, 1 } };

	private int round = 0;

	private int x = 0;

	private int y = 0;

	public KnightsTour(Chezzboard board) {
		this.board = board;
		Random rand = new Random();
		x = rand.nextInt(8);
		y = rand.nextInt(8);
	}

	public KnightsTour(Chezzboard board, final int x, final int y) {
		this.board = board;
		this.x = x;
		this.y = y;
	}

	public boolean hasNextRound() {
		return round < 65;
	}

	public int getRound() {
		return round;
	}

	public void nextRound() {
		++round;
		final var validaPosicao = validaPosicao(x, y);
		if (validaPosicao) {
			board.updatePosition(x,y,round);
		}
		nextPosition();
	}

	private boolean validaPosicao(final int x, final int y) {
		return x >= 0 && x <= 7 && y >= 0 && y <= 7 && board.getPosition(x,y) == null;
	}

	private void nextPosition() {
		final var pesos = pesosProxPosicao();
		final var indice = menorPosicao(pesos);
		x += nextPosition[indice][0];
		y += nextPosition[indice][1];
	}

	private Integer[] pesosProxPosicao() {
		final Integer[] posicoes = {
				0, 0, 0, 0, 0, 0, 0, 0 };
		for (var i = 0; i < 8; i++) {
			x += nextPosition[i][0];
			y += nextPosition[i][1];
			if (validaPosicao(x, y)) {
				posicoes[i] = somaProxPosicao();
			}
			x -= nextPosition[i][0];
			y -= nextPosition[i][1];
		}
		return posicoes;
	}

	private int menorPosicao(final Integer[] vetor) {
		var min = 7;
		var indice = 0;
		for (var i = 0; i < 8; i++) {
			if (vetor[i] < min && vetor[i] != 0) {
				min = vetor[i];
				indice = i;
			}
		}
		return indice;
	}

	private int somaProxPosicao() {
		var soma = 0;
		for (var i = 0; i < 8; i++) {
			if (validaPosicao(x + nextPosition[i][0], y + nextPosition[i][1])) {
				soma++;
			}
		}
		return soma;
	}

}