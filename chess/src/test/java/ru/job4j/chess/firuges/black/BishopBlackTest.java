package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void WriteInitialPosition() {
        Cell initial = Cell.B2;
        Figure bishop = new BishopBlack(initial);
        assertThat(bishop.position(), is(initial));
    }

    @Test
    public void WrongInitialPosition() {
        Cell initial = Cell.G3;
        Figure bishop = new BishopBlack(initial);
        boolean wrongAnswer = bishop.position().equals(Cell.E2);
        assertThat(wrongAnswer, is(false));
    }

    @Test
    public void WriteCopy() {
        Cell initial = Cell.D1;
        Figure bishop = new BishopBlack(initial);
        bishop = bishop.copy(Cell.A1);
        assertThat(bishop.position(), is(Cell.A1));
    }

    @Test
    public void WrongCopy() {
        Cell initial = Cell.A1;
        Figure bishop = new BishopBlack(initial);
        bishop = bishop.copy(Cell.H8);
        boolean wrongAnswer = bishop.position().equals(Cell.A1);
        assertThat(wrongAnswer, is(false));
    }

    @Test
    public void WriteWay() throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] path = bishop.way(Cell.G5);
        assertThat(path, is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void WrongWay() throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.F3);
        Cell[] path = bishop.way(Cell.H8);
    }
}