package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.KingWhite;

public class LogicTest {

    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void doubleMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        logic.move(Cell.C1, Cell.H6);
        logic.move(Cell.H6, Cell.G7);
    }

    @Test(expected = OccupiedCellException.class)
    public void throwOccupiedCell() throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.A1);
        Figure anyFigure = new KingWhite(Cell.B2);
        logic.add(bishop);
        logic.add(anyFigure);
        logic.move(bishop.position(), Cell.B2);
    }

    @Test(expected = FigureNotFoundException.class)
    public void throwFigureNotFound() throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.A1);
        Figure anyFigure = new KingWhite(Cell.B3);
        logic.add(anyFigure);
        logic.move(bishop.position(), Cell.B2);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void throwImpossibleMove() throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.A1);
        logic.add(bishop);
        logic.move(bishop.position(), Cell.B3);
    }
}