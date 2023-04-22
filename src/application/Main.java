package application;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
       while(true) {
           UI.printBoard(chessMatch.getPieces());
           System.out.println();
           System.out.println("Source: ");
           ChessPosition source = UI.readChessPosition(input);

           System.out.println();
           System.out.println("Target: ");
           ChessPosition target = UI.readChessPosition(input);

           ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
       }
    }
}