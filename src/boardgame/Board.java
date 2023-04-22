package boardgame;

public class Board {

    private Integer rows;
    private Integer colums;
    private Piece[][] pieces;

    public Board(Integer rows, Integer colums) {
        if(rows < 1 || colums < 1){
            throw new BoardException("Error creating board: there must be at least one row and one column to start the game");
        }
        this.rows = rows;
        this.colums = colums;
        pieces = new Piece[rows][colums];
    }

    public Integer getRows() {
        return rows;
    }
    public Integer getColums() {
        return colums;
    }
    public Piece piece(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("Position is not in the board of the game!");
        }
        return pieces[row][column];
    }
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position is not in the board of the game!");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position is not in the board of the game");
        }
        if(piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }


    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >=0 && column < colums;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position is not in the board of the game!");
        }
        return piece(position) != null;
    }



}
