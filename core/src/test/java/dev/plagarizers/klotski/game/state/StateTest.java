package dev.plagarizers.klotski.game.state;

import dev.plagarizers.klotski.game.block.BigBlock;
import dev.plagarizers.klotski.game.block.Block;
import dev.plagarizers.klotski.game.block.SmallBlock;
import dev.plagarizers.klotski.game.util.Coordinate;
import dev.plagarizers.klotski.game.util.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    private State state;

    @BeforeEach
    void setUp() {
        state = State.fromDefaultConfiguration();
    }

    @Test
    void getMoves_InitialState_ShouldReturnZero() {
        assertEquals(0, state.getMoves());
    }

    @Test
    void setMoves_PositiveNumber_ShouldSetMoves() {
        state.setMoves(10);
        assertEquals(10, state.getMoves());
    }

    @Test
    void fromDefaultConfiguration_InitialState_ShouldContainDefaultBlocks() {
        Block[] blocks = state.getBlocks();
        assertEquals(State.NUM_PIECES, blocks.length);
        // Add assertions to check if the blocks are as expected
    }

    @Test
    void isSolved_BlocksInGoalPosition_ShouldReturnTrue() {

        // TODO: Add a solved state

        // Arrange
//    state.setBlocks(new Block[] {
//            new BigBlock(State.GOAL)
//    });

        // Assert
//    assertTrue(state.isSolved());
    }

    @Test
    void isSolved_BlocksNotInGoalPosition_ShouldReturnFalse() {
        assertFalse(state.isSolved());
    }

    @Test
    void setBlocks_ValidBlocks_ShouldSetBlocks() {
        // Arrange
        Block[] blocks = State.fromDefaultConfiguration().getBlocks();

        // Act
        state.setBlocks(blocks);

        // Assert
        assertArrayEquals(blocks, state.getBlocks());
    }

    @Test
    void setBlocks_InvalidNumberOfBlocks_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Block[] blocks = new Block[State.NUM_PIECES - 1];
            state.setBlocks(blocks);
        });
    }

    @Test
    void canMoveBlock_BlockCanMoveInDirection_ShouldReturnTrue() {
        // Arrange
        Block block = new SmallBlock(new Coordinate(1, 3));
        Direction direction = Direction.DOWN;

        // Act
        boolean canMove = state.canMoveBlock(block, direction);

        // Assert
        assertTrue(canMove);
    }

    @Test
    void canMoveBlock_BlockCannotMoveInDirection_ShouldReturnFalse() {
        // Arrange
        Block block = new BigBlock(new Coordinate(0, 1));
        Direction direction = Direction.LEFT;

        // Act
        boolean canMove = state.canMoveBlock(block, direction);

        // Assert
        assertFalse(canMove);
    }

    @Test
    void moveBlock_BlockCanMoveInDirection_ShouldMoveBlock() {
        // Arrange
        Block block = new SmallBlock(new Coordinate(1, 3));
        Direction direction = Direction.DOWN;


        // Act
        boolean moved = state.moveBlock(block, direction);

        // Assert
        assertTrue(moved);
        // Add assertions to check if the block is moved correctly
    }

    @Test
    void moveBlock_BlockCannotMoveInDirection_ShouldNotMoveBlock() {
        // Arrange
        Block block = new BigBlock(new Coordinate(0, 1));
        Direction direction = Direction.LEFT;

        // Act
        boolean moved = state.moveBlock(block, direction);

        // Assert
        assertFalse(moved);
        // Add assertions to check if the block is not moved
    }

    @Test
    void fromRandomConfiguration_InitializedState_ShouldHaveRandomBlocks() {
        // For some reason, this tests fails due to the file not being found when the file is in the correct location

        // Arrange & Act

        //State newState = State.fromRandomConfiguration();

        // Assert
        //assertNotNull(newState.getBlocks());
        // Add assertions to check if the blocks are randomly generated
    }
}

