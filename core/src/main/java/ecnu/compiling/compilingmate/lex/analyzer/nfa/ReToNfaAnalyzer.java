package ecnu.compiling.compilingmate.lex.analyzer.nfa;

import ecnu.compiling.compilingmate.lex.analyzer.AbstractAnalyzer;
import ecnu.compiling.compilingmate.lex.constants.LexConstants;
import ecnu.compiling.compilingmate.lex.dto.ReToNfaDto;
import ecnu.compiling.compilingmate.lex.entity.Token;
import ecnu.compiling.compilingmate.lex.exception.BadUserInputException;
import ecnu.compiling.compilingmate.lex.policy.ScannerFactory;
import ecnu.compiling.compilingmate.lex.policy.rule.DefaultReRule;
import ecnu.compiling.compilingmate.lex.policy.rule.Rule;
import ecnu.compiling.compilingmate.lex.policy.scanner.LexScanner;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public abstract class ReToNfaAnalyzer extends AbstractAnalyzer<String, ReToNfaDto> {

    private LexScanner scanner;

    /**
     * 主流程（对外接口）
     *
     * @param input
     * @return
     */
    @Override
    public ReToNfaDto process(String input) throws BadUserInputException{

        this.scanner = ScannerFactory.getLexScanner(this.getRule());

        List<Token> formattedInput = scanner.parse(input);

        return this.process(formattedInput);
    }

    protected abstract ReToNfaDto process(List<Token> input);

}
