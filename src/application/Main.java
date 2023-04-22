package application;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        try {
            while (true) {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.println("Source: ");
                ChessPosition source = UI.readChessPosition(input);

                System.out.println();
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(input);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
        }catch (ChessException e){
            System.out.println(e.getMessage());
            input.nextLine();
        }catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            input.nextLine();
        }
    }
}
