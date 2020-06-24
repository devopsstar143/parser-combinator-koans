package parserkoans

import org.junit.Ignore
import org.junit.Test

class `Step 7 - minus parser` {

    private val expression: Parser<Expression> = TODO("combine parsers")

    @Ignore
    @Test fun `1 - subtract two numbers`() {
        expression.parse(Input("1 - 2"))?.payload shouldEqual Minus(IntLiteral(1), IntLiteral(2))
        expression.parse(Input("2 - 1"))?.payload shouldEqual Minus(IntLiteral(2), IntLiteral(1))
    }

    @Ignore
    @Test fun `2 - subtract three numbers (left associative)`() {
        expression.parse(Input("1 - 2 - 3"))?.payload.let {
            it shouldEqual Minus(
                Minus(IntLiteral(1), IntLiteral(2)),
                IntLiteral(3)
            )
            it.toStringExpression() shouldEqual "((1 - 2) - 3)"
            it.evaluate() shouldEqual -4
        }
    }
}
