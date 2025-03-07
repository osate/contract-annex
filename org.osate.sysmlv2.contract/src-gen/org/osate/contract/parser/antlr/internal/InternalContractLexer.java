package org.osate.contract.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContractLexer extends Lexer {
    public static final int T__50=50;
    public static final int RULE_ISTRING_TEXT=7;
    public static final int RULE_INT_EXPONENT=17;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_BASED_INTEGER=18;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_DIGIT=15;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_ISTRING_RIGHT=10;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int RULE_INTEGER_LIT=11;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_REAL_LIT=12;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=14;
    public static final int RULE_SSTRING=5;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_ISTRING_MIDDLE=9;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int RULE_IN_ISTRING=13;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=20;
    public static final int RULE_EXPONENT=16;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int RULE_ISTRING_LEFT=8;
    public static final int RULE_EXTENDED_DIGIT=19;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators

    public InternalContractLexer() {;} 
    public InternalContractLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalContractLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalContract.g"; }

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:11:7: ( 'package' )
            // InternalContract.g:11:9: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:12:7: ( ';' )
            // InternalContract.g:12:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:13:7: ( 'contract' )
            // InternalContract.g:13:9: 'contract'
            {
            match("contract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:14:7: ( '{' )
            // InternalContract.g:14:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:15:7: ( 'domains' )
            // InternalContract.g:15:9: 'domains'
            {
            match("domains"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:16:7: ( 'queries' )
            // InternalContract.g:16:9: 'queries'
            {
            match("queries"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:17:7: ( 'input' )
            // InternalContract.g:17:9: 'input'
            {
            match("input"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:18:7: ( 'assumptions' )
            // InternalContract.g:18:9: 'assumptions'
            {
            match("assumptions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:19:7: ( 'guarantee' )
            // InternalContract.g:19:9: 'guarantee'
            {
            match("guarantee"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:20:7: ( 'invocation' )
            // InternalContract.g:20:9: 'invocation'
            {
            match("invocation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:21:7: ( 'analysis' )
            // InternalContract.g:21:9: 'analysis'
            {
            match("analysis"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:22:7: ( '}' )
            // InternalContract.g:22:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:23:7: ( '=>' )
            // InternalContract.g:23:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:24:7: ( '<=>' )
            // InternalContract.g:24:9: '<=>'
            {
            match("<=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:25:7: ( 'argument' )
            // InternalContract.g:25:9: 'argument'
            {
            match("argument"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:26:7: ( 'implementation' )
            // InternalContract.g:26:9: 'implementation'
            {
            match("implementation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:27:7: ( 'domain' )
            // InternalContract.g:27:9: 'domain'
            {
            match("domain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:28:7: ( 'declarations' )
            // InternalContract.g:28:9: 'declarations'
            {
            match("declarations"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:29:7: ( 'and' )
            // InternalContract.g:29:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:30:7: ( '(' )
            // InternalContract.g:30:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:31:7: ( ',' )
            // InternalContract.g:31:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:32:7: ( ')' )
            // InternalContract.g:32:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:33:7: ( 'or' )
            // InternalContract.g:33:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:34:7: ( 'not' )
            // InternalContract.g:34:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:35:7: ( 'verification' )
            // InternalContract.g:35:9: 'verification'
            {
            match("verification"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:36:7: ( 'plan' )
            // InternalContract.g:36:9: 'plan'
            {
            match("plan"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:37:7: ( 'component' )
            // InternalContract.g:37:9: 'component'
            {
            match("component"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:38:7: ( ':' )
            // InternalContract.g:38:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:39:7: ( 'claims' )
            // InternalContract.g:39:9: 'claims'
            {
            match("claims"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:40:7: ( 'contracts' )
            // InternalContract.g:40:9: 'contracts'
            {
            match("contracts"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:41:7: ( 'val' )
            // InternalContract.g:41:9: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:42:7: ( '=' )
            // InternalContract.g:42:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:43:7: ( '||' )
            // InternalContract.g:43:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:44:7: ( '&&' )
            // InternalContract.g:44:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:45:7: ( '!' )
            // InternalContract.g:45:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:46:7: ( '.' )
            // InternalContract.g:46:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:47:7: ( '<' )
            // InternalContract.g:47:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:48:7: ( '>' )
            // InternalContract.g:48:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:49:7: ( '#' )
            // InternalContract.g:49:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:50:7: ( '->' )
            // InternalContract.g:50:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:51:7: ( 'self' )
            // InternalContract.g:51:9: 'self'
            {
            match("self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:52:7: ( 'root' )
            // InternalContract.g:52:9: 'root'
            {
            match("root"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:53:7: ( '::' )
            // InternalContract.g:53:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:54:7: ( '+=>' )
            // InternalContract.g:54:9: '+=>'
            {
            match("+=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:55:7: ( 'constant' )
            // InternalContract.g:55:9: 'constant'
            {
            match("constant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:56:7: ( 'true' )
            // InternalContract.g:56:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:57:7: ( 'false' )
            // InternalContract.g:57:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:58:7: ( 'reference' )
            // InternalContract.g:58:9: 'reference'
            {
            match("reference"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:59:7: ( '[' )
            // InternalContract.g:59:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:60:7: ( ']' )
            // InternalContract.g:60:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:61:7: ( 'compute' )
            // InternalContract.g:61:9: 'compute'
            {
            match("compute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:62:7: ( 'classifier' )
            // InternalContract.g:62:9: 'classifier'
            {
            match("classifier"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:63:7: ( '+' )
            // InternalContract.g:63:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:64:7: ( '-' )
            // InternalContract.g:64:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:65:7: ( '..' )
            // InternalContract.g:65:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:66:7: ( 'delta' )
            // InternalContract.g:66:9: 'delta'
            {
            match("delta"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:67:7: ( 'applies' )
            // InternalContract.g:67:9: 'applies'
            {
            match("applies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:68:7: ( 'to' )
            // InternalContract.g:68:9: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:69:7: ( 'in' )
            // InternalContract.g:69:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:70:7: ( 'binding' )
            // InternalContract.g:70:9: 'binding'
            {
            match("binding"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:71:7: ( 'modes' )
            // InternalContract.g:71:9: 'modes'
            {
            match("modes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:72:7: ( '*' )
            // InternalContract.g:72:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:73:7: ( 'python' )
            // InternalContract.g:73:9: 'python'
            {
            match("python"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:74:7: ( 'java' )
            // InternalContract.g:74:9: 'java'
            {
            match("java"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:75:7: ( 'smt' )
            // InternalContract.g:75:9: 'smt'
            {
            match("smt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:76:7: ( 'error0' )
            // InternalContract.g:76:9: 'error0'
            {
            match("error0"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:77:7: ( 'info0' )
            // InternalContract.g:77:9: 'info0'
            {
            match("info0"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "RULE_ISTRING_TEXT"
    public final void mRULE_ISTRING_TEXT() throws RecognitionException {
        try {
            int _type = RULE_ISTRING_TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4866:19: ( '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // InternalContract.g:4866:21: '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match("'''"); 

            // InternalContract.g:4866:30: ( RULE_IN_ISTRING )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\'') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='\'') ) {
                        int LA1_4 = input.LA(3);

                        if ( ((LA1_4>='\u0000' && LA1_4<='&')||(LA1_4>='(' && LA1_4<='\uFFFF')) ) {
                            alt1=1;
                        }


                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='&')||(LA1_1>='(' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='&')||(LA1_0>='(' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContract.g:4866:30: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalContract.g:4866:47: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\'') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='\'') ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3=='\'') ) {
                        alt4=1;
                    }
                    else {
                        alt4=2;}
                }
                else {
                    alt4=2;}
            }
            else {
                alt4=2;}
            switch (alt4) {
                case 1 :
                    // InternalContract.g:4866:48: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // InternalContract.g:4866:57: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // InternalContract.g:4866:57: ( '\\'' ( '\\'' )? )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\'') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalContract.g:4866:58: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // InternalContract.g:4866:63: ( '\\'' )?
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( (LA2_0=='\'') ) {
                                alt2=1;
                            }
                            switch (alt2) {
                                case 1 :
                                    // InternalContract.g:4866:63: '\\''
                                    {
                                    match('\''); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    match(EOF); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ISTRING_TEXT"

    // $ANTLR start "RULE_ISTRING_LEFT"
    public final void mRULE_ISTRING_LEFT() throws RecognitionException {
        try {
            int _type = RULE_ISTRING_LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4868:19: ( '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${' )
            // InternalContract.g:4868:21: '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${'
            {
            match("'''"); 

            // InternalContract.g:4868:30: ( RULE_IN_ISTRING )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\'') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='\'') ) {
                        int LA5_4 = input.LA(3);

                        if ( (LA5_4=='$') ) {
                            int LA5_7 = input.LA(4);

                            if ( (LA5_7=='{') ) {
                                int LA5_8 = input.LA(5);

                                if ( ((LA5_8>='\u0000' && LA5_8<='\uFFFF')) ) {
                                    alt5=1;
                                }


                            }
                            else if ( ((LA5_7>='\u0000' && LA5_7<='z')||(LA5_7>='|' && LA5_7<='\uFFFF')) ) {
                                alt5=1;
                            }


                        }
                        else if ( ((LA5_4>='\u0000' && LA5_4<='#')||(LA5_4>='%' && LA5_4<='&')||(LA5_4>='(' && LA5_4<='\uFFFF')) ) {
                            alt5=1;
                        }


                    }
                    else if ( (LA5_1=='$') ) {
                        int LA5_5 = input.LA(3);

                        if ( (LA5_5=='{') ) {
                            int LA5_8 = input.LA(4);

                            if ( ((LA5_8>='\u0000' && LA5_8<='\uFFFF')) ) {
                                alt5=1;
                            }


                        }
                        else if ( ((LA5_5>='\u0000' && LA5_5<='z')||(LA5_5>='|' && LA5_5<='\uFFFF')) ) {
                            alt5=1;
                        }


                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='#')||(LA5_1>='%' && LA5_1<='&')||(LA5_1>='(' && LA5_1<='\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( (LA5_0=='$') ) {
                    int LA5_2 = input.LA(2);

                    if ( ((LA5_2>='\u0000' && LA5_2<='z')||(LA5_2>='|' && LA5_2<='\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='#')||(LA5_0>='%' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalContract.g:4868:30: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalContract.g:4868:47: ( '\\'' ( '\\'' )? )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\'') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalContract.g:4868:48: '\\'' ( '\\'' )?
                    {
                    match('\''); 
                    // InternalContract.g:4868:53: ( '\\'' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\'') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalContract.g:4868:53: '\\''
                            {
                            match('\''); 

                            }
                            break;

                    }


                    }
                    break;

            }

            match("${"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ISTRING_LEFT"

    // $ANTLR start "RULE_ISTRING_MIDDLE"
    public final void mRULE_ISTRING_MIDDLE() throws RecognitionException {
        try {
            int _type = RULE_ISTRING_MIDDLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4870:21: ( '$}' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${' )
            // InternalContract.g:4870:23: '$}' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${'
            {
            match("$}"); 

            // InternalContract.g:4870:28: ( RULE_IN_ISTRING )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\'') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='\'') ) {
                        int LA8_4 = input.LA(3);

                        if ( (LA8_4=='$') ) {
                            int LA8_7 = input.LA(4);

                            if ( (LA8_7=='{') ) {
                                int LA8_8 = input.LA(5);

                                if ( ((LA8_8>='\u0000' && LA8_8<='\uFFFF')) ) {
                                    alt8=1;
                                }


                            }
                            else if ( ((LA8_7>='\u0000' && LA8_7<='z')||(LA8_7>='|' && LA8_7<='\uFFFF')) ) {
                                alt8=1;
                            }


                        }
                        else if ( ((LA8_4>='\u0000' && LA8_4<='#')||(LA8_4>='%' && LA8_4<='&')||(LA8_4>='(' && LA8_4<='\uFFFF')) ) {
                            alt8=1;
                        }


                    }
                    else if ( (LA8_1=='$') ) {
                        int LA8_5 = input.LA(3);

                        if ( (LA8_5=='{') ) {
                            int LA8_8 = input.LA(4);

                            if ( ((LA8_8>='\u0000' && LA8_8<='\uFFFF')) ) {
                                alt8=1;
                            }


                        }
                        else if ( ((LA8_5>='\u0000' && LA8_5<='z')||(LA8_5>='|' && LA8_5<='\uFFFF')) ) {
                            alt8=1;
                        }


                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='#')||(LA8_1>='%' && LA8_1<='&')||(LA8_1>='(' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( (LA8_0=='$') ) {
                    int LA8_2 = input.LA(2);

                    if ( ((LA8_2>='\u0000' && LA8_2<='z')||(LA8_2>='|' && LA8_2<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='#')||(LA8_0>='%' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalContract.g:4870:28: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalContract.g:4870:45: ( '\\'' ( '\\'' )? )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\'') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalContract.g:4870:46: '\\'' ( '\\'' )?
                    {
                    match('\''); 
                    // InternalContract.g:4870:51: ( '\\'' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\'') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalContract.g:4870:51: '\\''
                            {
                            match('\''); 

                            }
                            break;

                    }


                    }
                    break;

            }

            match("${"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ISTRING_MIDDLE"

    // $ANTLR start "RULE_ISTRING_RIGHT"
    public final void mRULE_ISTRING_RIGHT() throws RecognitionException {
        try {
            int _type = RULE_ISTRING_RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4872:20: ( '$}' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // InternalContract.g:4872:22: '$}' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match("$}"); 

            // InternalContract.g:4872:27: ( RULE_IN_ISTRING )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\'') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='\'') ) {
                        int LA11_4 = input.LA(3);

                        if ( ((LA11_4>='\u0000' && LA11_4<='&')||(LA11_4>='(' && LA11_4<='\uFFFF')) ) {
                            alt11=1;
                        }


                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='&')||(LA11_1>='(' && LA11_1<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='&')||(LA11_0>='(' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalContract.g:4872:27: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalContract.g:4872:44: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\'') ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1=='\'') ) {
                    int LA14_3 = input.LA(3);

                    if ( (LA14_3=='\'') ) {
                        alt14=1;
                    }
                    else {
                        alt14=2;}
                }
                else {
                    alt14=2;}
            }
            else {
                alt14=2;}
            switch (alt14) {
                case 1 :
                    // InternalContract.g:4872:45: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // InternalContract.g:4872:54: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // InternalContract.g:4872:54: ( '\\'' ( '\\'' )? )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\'') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalContract.g:4872:55: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // InternalContract.g:4872:60: ( '\\'' )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0=='\'') ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // InternalContract.g:4872:60: '\\''
                                    {
                                    match('\''); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    match(EOF); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ISTRING_RIGHT"

    // $ANTLR start "RULE_IN_ISTRING"
    public final void mRULE_IN_ISTRING() throws RecognitionException {
        try {
            // InternalContract.g:4874:26: ( ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | '$' ~ ( '{' ) | ~ ( ( '\\'' | '$' ) ) ) )
            // InternalContract.g:4874:28: ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | '$' ~ ( '{' ) | ~ ( ( '\\'' | '$' ) ) )
            {
            // InternalContract.g:4874:28: ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | '$' ~ ( '{' ) | ~ ( ( '\\'' | '$' ) ) )
            int alt15=4;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\'') ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1=='\'') ) {
                    alt15=1;
                }
                else if ( ((LA15_1>='\u0000' && LA15_1<='&')||(LA15_1>='(' && LA15_1<='\uFFFF')) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA15_0=='$') ) {
                alt15=3;
            }
            else if ( ((LA15_0>='\u0000' && LA15_0<='#')||(LA15_0>='%' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='\uFFFF')) ) {
                alt15=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalContract.g:4874:29: '\\'\\'' ~ ( '\\'' )
                    {
                    match("''"); 

                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // InternalContract.g:4874:44: '\\'' ~ ( '\\'' )
                    {
                    match('\''); 
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 3 :
                    // InternalContract.g:4874:57: '$' ~ ( '{' )
                    {
                    match('$'); 
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='z')||(input.LA(1)>='|' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 4 :
                    // InternalContract.g:4874:68: ~ ( ( '\\'' | '$' ) )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='#')||(input.LA(1)>='%' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_IN_ISTRING"

    // $ANTLR start "RULE_SSTRING"
    public final void mRULE_SSTRING() throws RecognitionException {
        try {
            int _type = RULE_SSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4876:14: ( '`' (~ ( '`' ) )* '`' )
            // InternalContract.g:4876:16: '`' (~ ( '`' ) )* '`'
            {
            match('`'); 
            // InternalContract.g:4876:20: (~ ( '`' ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='_')||(LA16_0>='a' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalContract.g:4876:20: ~ ( '`' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='_')||(input.LA(1)>='a' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match('`'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SSTRING"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4878:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalContract.g:4878:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // InternalContract.g:4878:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalContract.g:4878:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // InternalContract.g:4878:40: ( ( '\\r' )? '\\n' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\n'||LA19_0=='\r') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalContract.g:4878:41: ( '\\r' )? '\\n'
                    {
                    // InternalContract.g:4878:41: ( '\\r' )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='\r') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalContract.g:4878:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        try {
            // InternalContract.g:4880:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+ )
            // InternalContract.g:4880:26: ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalContract.g:4880:36: ( '+' | '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='+'||LA20_0=='-') ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalContract.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalContract.g:4880:47: ( RULE_DIGIT )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='0' && LA21_0<='9')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalContract.g:4880:47: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_INT_EXPONENT"
    public final void mRULE_INT_EXPONENT() throws RecognitionException {
        try {
            // InternalContract.g:4882:28: ( ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+ )
            // InternalContract.g:4882:30: ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalContract.g:4882:40: ( '+' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='+') ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalContract.g:4882:40: '+'
                    {
                    match('+'); 

                    }
                    break;

            }

            // InternalContract.g:4882:45: ( RULE_DIGIT )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='0' && LA23_0<='9')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalContract.g:4882:45: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT_EXPONENT"

    // $ANTLR start "RULE_REAL_LIT"
    public final void mRULE_REAL_LIT() throws RecognitionException {
        try {
            int _type = RULE_REAL_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4884:15: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )? )
            // InternalContract.g:4884:17: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )?
            {
            // InternalContract.g:4884:17: ( RULE_DIGIT )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='0' && LA24_0<='9')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalContract.g:4884:17: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            // InternalContract.g:4884:29: ( '_' ( RULE_DIGIT )+ )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0=='_') ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalContract.g:4884:30: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // InternalContract.g:4884:34: ( RULE_DIGIT )+
            	    int cnt25=0;
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( ((LA25_0>='0' && LA25_0<='9')) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // InternalContract.g:4884:34: RULE_DIGIT
            	    	    {
            	    	    mRULE_DIGIT(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt25 >= 1 ) break loop25;
            	                EarlyExitException eee =
            	                    new EarlyExitException(25, input);
            	                throw eee;
            	        }
            	        cnt25++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            match('.'); 
            // InternalContract.g:4884:52: ( RULE_DIGIT )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='0' && LA27_0<='9')) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalContract.g:4884:52: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            // InternalContract.g:4884:64: ( '_' ( RULE_DIGIT )+ )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0=='_') ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalContract.g:4884:65: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // InternalContract.g:4884:69: ( RULE_DIGIT )+
            	    int cnt28=0;
            	    loop28:
            	    do {
            	        int alt28=2;
            	        int LA28_0 = input.LA(1);

            	        if ( ((LA28_0>='0' && LA28_0<='9')) ) {
            	            alt28=1;
            	        }


            	        switch (alt28) {
            	    	case 1 :
            	    	    // InternalContract.g:4884:69: RULE_DIGIT
            	    	    {
            	    	    mRULE_DIGIT(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt28 >= 1 ) break loop28;
            	                EarlyExitException eee =
            	                    new EarlyExitException(28, input);
            	                throw eee;
            	        }
            	        cnt28++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // InternalContract.g:4884:83: ( RULE_EXPONENT )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0=='E'||LA30_0=='e') ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalContract.g:4884:83: RULE_EXPONENT
                    {
                    mRULE_EXPONENT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_REAL_LIT"

    // $ANTLR start "RULE_INTEGER_LIT"
    public final void mRULE_INTEGER_LIT() throws RecognitionException {
        try {
            int _type = RULE_INTEGER_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4886:18: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? ) )
            // InternalContract.g:4886:20: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? )
            {
            // InternalContract.g:4886:20: ( RULE_DIGIT )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>='0' && LA31_0<='9')) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalContract.g:4886:20: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            // InternalContract.g:4886:32: ( '_' ( RULE_DIGIT )+ )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0=='_') ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalContract.g:4886:33: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // InternalContract.g:4886:37: ( RULE_DIGIT )+
            	    int cnt32=0;
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( ((LA32_0>='0' && LA32_0<='9')) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // InternalContract.g:4886:37: RULE_DIGIT
            	    	    {
            	    	    mRULE_DIGIT(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt32 >= 1 ) break loop32;
            	                EarlyExitException eee =
            	                    new EarlyExitException(32, input);
            	                throw eee;
            	        }
            	        cnt32++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            // InternalContract.g:4886:51: ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0=='#') ) {
                alt36=1;
            }
            else {
                alt36=2;}
            switch (alt36) {
                case 1 :
                    // InternalContract.g:4886:52: '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )?
                    {
                    match('#'); 
                    mRULE_BASED_INTEGER(); 
                    match('#'); 
                    // InternalContract.g:4886:79: ( RULE_INT_EXPONENT )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0=='E'||LA34_0=='e') ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalContract.g:4886:79: RULE_INT_EXPONENT
                            {
                            mRULE_INT_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:4886:98: ( RULE_INT_EXPONENT )?
                    {
                    // InternalContract.g:4886:98: ( RULE_INT_EXPONENT )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0=='E'||LA35_0=='e') ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalContract.g:4886:98: RULE_INT_EXPONENT
                            {
                            mRULE_INT_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER_LIT"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalContract.g:4888:21: ( '0' .. '9' )
            // InternalContract.g:4888:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_EXTENDED_DIGIT"
    public final void mRULE_EXTENDED_DIGIT() throws RecognitionException {
        try {
            // InternalContract.g:4890:30: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // InternalContract.g:4890:32: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXTENDED_DIGIT"

    // $ANTLR start "RULE_BASED_INTEGER"
    public final void mRULE_BASED_INTEGER() throws RecognitionException {
        try {
            // InternalContract.g:4892:29: ( RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )* )
            // InternalContract.g:4892:31: RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )*
            {
            mRULE_EXTENDED_DIGIT(); 
            // InternalContract.g:4892:51: ( ( '_' )? RULE_EXTENDED_DIGIT )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>='0' && LA38_0<='9')||(LA38_0>='A' && LA38_0<='F')||LA38_0=='_'||(LA38_0>='a' && LA38_0<='f')) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalContract.g:4892:52: ( '_' )? RULE_EXTENDED_DIGIT
            	    {
            	    // InternalContract.g:4892:52: ( '_' )?
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0=='_') ) {
            	        alt37=1;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // InternalContract.g:4892:52: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    mRULE_EXTENDED_DIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BASED_INTEGER"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4894:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalContract.g:4894:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalContract.g:4894:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0=='\"') ) {
                alt41=1;
            }
            else if ( (LA41_0=='\'') ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalContract.g:4894:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalContract.g:4894:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop39:
                    do {
                        int alt39=3;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0=='\\') ) {
                            alt39=1;
                        }
                        else if ( ((LA39_0>='\u0000' && LA39_0<='!')||(LA39_0>='#' && LA39_0<='[')||(LA39_0>=']' && LA39_0<='\uFFFF')) ) {
                            alt39=2;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalContract.g:4894:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalContract.g:4894:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalContract.g:4894:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalContract.g:4894:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop40:
                    do {
                        int alt40=3;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0=='\\') ) {
                            alt40=1;
                        }
                        else if ( ((LA40_0>='\u0000' && LA40_0<='&')||(LA40_0>='(' && LA40_0<='[')||(LA40_0>=']' && LA40_0<='\uFFFF')) ) {
                            alt40=2;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalContract.g:4894:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalContract.g:4894:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4896:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )* )
            // InternalContract.g:4896:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalContract.g:4896:31: ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>='0' && LA43_0<='9')||(LA43_0>='A' && LA43_0<='Z')||LA43_0=='_'||(LA43_0>='a' && LA43_0<='z')) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalContract.g:4896:32: ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
            	    {
            	    // InternalContract.g:4896:32: ( '_' )?
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0=='_') ) {
            	        alt42=1;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // InternalContract.g:4896:32: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:4898:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalContract.g:4898:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalContract.g:4898:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>='\t' && LA44_0<='\n')||LA44_0=='\r'||LA44_0==' ') ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalContract.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    public void mTokens() throws RecognitionException {
        // InternalContract.g:1:8: ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | RULE_ISTRING_TEXT | RULE_ISTRING_LEFT | RULE_ISTRING_MIDDLE | RULE_ISTRING_RIGHT | RULE_SSTRING | RULE_SL_COMMENT | RULE_REAL_LIT | RULE_INTEGER_LIT | RULE_STRING | RULE_ID | RULE_WS )
        int alt45=78;
        alt45 = dfa45.predict(input);
        switch (alt45) {
            case 1 :
                // InternalContract.g:1:10: T__21
                {
                mT__21(); 

                }
                break;
            case 2 :
                // InternalContract.g:1:16: T__22
                {
                mT__22(); 

                }
                break;
            case 3 :
                // InternalContract.g:1:22: T__23
                {
                mT__23(); 

                }
                break;
            case 4 :
                // InternalContract.g:1:28: T__24
                {
                mT__24(); 

                }
                break;
            case 5 :
                // InternalContract.g:1:34: T__25
                {
                mT__25(); 

                }
                break;
            case 6 :
                // InternalContract.g:1:40: T__26
                {
                mT__26(); 

                }
                break;
            case 7 :
                // InternalContract.g:1:46: T__27
                {
                mT__27(); 

                }
                break;
            case 8 :
                // InternalContract.g:1:52: T__28
                {
                mT__28(); 

                }
                break;
            case 9 :
                // InternalContract.g:1:58: T__29
                {
                mT__29(); 

                }
                break;
            case 10 :
                // InternalContract.g:1:64: T__30
                {
                mT__30(); 

                }
                break;
            case 11 :
                // InternalContract.g:1:70: T__31
                {
                mT__31(); 

                }
                break;
            case 12 :
                // InternalContract.g:1:76: T__32
                {
                mT__32(); 

                }
                break;
            case 13 :
                // InternalContract.g:1:82: T__33
                {
                mT__33(); 

                }
                break;
            case 14 :
                // InternalContract.g:1:88: T__34
                {
                mT__34(); 

                }
                break;
            case 15 :
                // InternalContract.g:1:94: T__35
                {
                mT__35(); 

                }
                break;
            case 16 :
                // InternalContract.g:1:100: T__36
                {
                mT__36(); 

                }
                break;
            case 17 :
                // InternalContract.g:1:106: T__37
                {
                mT__37(); 

                }
                break;
            case 18 :
                // InternalContract.g:1:112: T__38
                {
                mT__38(); 

                }
                break;
            case 19 :
                // InternalContract.g:1:118: T__39
                {
                mT__39(); 

                }
                break;
            case 20 :
                // InternalContract.g:1:124: T__40
                {
                mT__40(); 

                }
                break;
            case 21 :
                // InternalContract.g:1:130: T__41
                {
                mT__41(); 

                }
                break;
            case 22 :
                // InternalContract.g:1:136: T__42
                {
                mT__42(); 

                }
                break;
            case 23 :
                // InternalContract.g:1:142: T__43
                {
                mT__43(); 

                }
                break;
            case 24 :
                // InternalContract.g:1:148: T__44
                {
                mT__44(); 

                }
                break;
            case 25 :
                // InternalContract.g:1:154: T__45
                {
                mT__45(); 

                }
                break;
            case 26 :
                // InternalContract.g:1:160: T__46
                {
                mT__46(); 

                }
                break;
            case 27 :
                // InternalContract.g:1:166: T__47
                {
                mT__47(); 

                }
                break;
            case 28 :
                // InternalContract.g:1:172: T__48
                {
                mT__48(); 

                }
                break;
            case 29 :
                // InternalContract.g:1:178: T__49
                {
                mT__49(); 

                }
                break;
            case 30 :
                // InternalContract.g:1:184: T__50
                {
                mT__50(); 

                }
                break;
            case 31 :
                // InternalContract.g:1:190: T__51
                {
                mT__51(); 

                }
                break;
            case 32 :
                // InternalContract.g:1:196: T__52
                {
                mT__52(); 

                }
                break;
            case 33 :
                // InternalContract.g:1:202: T__53
                {
                mT__53(); 

                }
                break;
            case 34 :
                // InternalContract.g:1:208: T__54
                {
                mT__54(); 

                }
                break;
            case 35 :
                // InternalContract.g:1:214: T__55
                {
                mT__55(); 

                }
                break;
            case 36 :
                // InternalContract.g:1:220: T__56
                {
                mT__56(); 

                }
                break;
            case 37 :
                // InternalContract.g:1:226: T__57
                {
                mT__57(); 

                }
                break;
            case 38 :
                // InternalContract.g:1:232: T__58
                {
                mT__58(); 

                }
                break;
            case 39 :
                // InternalContract.g:1:238: T__59
                {
                mT__59(); 

                }
                break;
            case 40 :
                // InternalContract.g:1:244: T__60
                {
                mT__60(); 

                }
                break;
            case 41 :
                // InternalContract.g:1:250: T__61
                {
                mT__61(); 

                }
                break;
            case 42 :
                // InternalContract.g:1:256: T__62
                {
                mT__62(); 

                }
                break;
            case 43 :
                // InternalContract.g:1:262: T__63
                {
                mT__63(); 

                }
                break;
            case 44 :
                // InternalContract.g:1:268: T__64
                {
                mT__64(); 

                }
                break;
            case 45 :
                // InternalContract.g:1:274: T__65
                {
                mT__65(); 

                }
                break;
            case 46 :
                // InternalContract.g:1:280: T__66
                {
                mT__66(); 

                }
                break;
            case 47 :
                // InternalContract.g:1:286: T__67
                {
                mT__67(); 

                }
                break;
            case 48 :
                // InternalContract.g:1:292: T__68
                {
                mT__68(); 

                }
                break;
            case 49 :
                // InternalContract.g:1:298: T__69
                {
                mT__69(); 

                }
                break;
            case 50 :
                // InternalContract.g:1:304: T__70
                {
                mT__70(); 

                }
                break;
            case 51 :
                // InternalContract.g:1:310: T__71
                {
                mT__71(); 

                }
                break;
            case 52 :
                // InternalContract.g:1:316: T__72
                {
                mT__72(); 

                }
                break;
            case 53 :
                // InternalContract.g:1:322: T__73
                {
                mT__73(); 

                }
                break;
            case 54 :
                // InternalContract.g:1:328: T__74
                {
                mT__74(); 

                }
                break;
            case 55 :
                // InternalContract.g:1:334: T__75
                {
                mT__75(); 

                }
                break;
            case 56 :
                // InternalContract.g:1:340: T__76
                {
                mT__76(); 

                }
                break;
            case 57 :
                // InternalContract.g:1:346: T__77
                {
                mT__77(); 

                }
                break;
            case 58 :
                // InternalContract.g:1:352: T__78
                {
                mT__78(); 

                }
                break;
            case 59 :
                // InternalContract.g:1:358: T__79
                {
                mT__79(); 

                }
                break;
            case 60 :
                // InternalContract.g:1:364: T__80
                {
                mT__80(); 

                }
                break;
            case 61 :
                // InternalContract.g:1:370: T__81
                {
                mT__81(); 

                }
                break;
            case 62 :
                // InternalContract.g:1:376: T__82
                {
                mT__82(); 

                }
                break;
            case 63 :
                // InternalContract.g:1:382: T__83
                {
                mT__83(); 

                }
                break;
            case 64 :
                // InternalContract.g:1:388: T__84
                {
                mT__84(); 

                }
                break;
            case 65 :
                // InternalContract.g:1:394: T__85
                {
                mT__85(); 

                }
                break;
            case 66 :
                // InternalContract.g:1:400: T__86
                {
                mT__86(); 

                }
                break;
            case 67 :
                // InternalContract.g:1:406: T__87
                {
                mT__87(); 

                }
                break;
            case 68 :
                // InternalContract.g:1:412: RULE_ISTRING_TEXT
                {
                mRULE_ISTRING_TEXT(); 

                }
                break;
            case 69 :
                // InternalContract.g:1:430: RULE_ISTRING_LEFT
                {
                mRULE_ISTRING_LEFT(); 

                }
                break;
            case 70 :
                // InternalContract.g:1:448: RULE_ISTRING_MIDDLE
                {
                mRULE_ISTRING_MIDDLE(); 

                }
                break;
            case 71 :
                // InternalContract.g:1:468: RULE_ISTRING_RIGHT
                {
                mRULE_ISTRING_RIGHT(); 

                }
                break;
            case 72 :
                // InternalContract.g:1:487: RULE_SSTRING
                {
                mRULE_SSTRING(); 

                }
                break;
            case 73 :
                // InternalContract.g:1:500: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 74 :
                // InternalContract.g:1:516: RULE_REAL_LIT
                {
                mRULE_REAL_LIT(); 

                }
                break;
            case 75 :
                // InternalContract.g:1:530: RULE_INTEGER_LIT
                {
                mRULE_INTEGER_LIT(); 

                }
                break;
            case 76 :
                // InternalContract.g:1:547: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 77 :
                // InternalContract.g:1:559: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 78 :
                // InternalContract.g:1:567: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA45 dfa45 = new DFA45(this);
    static final String DFA45_eotS =
        "\1\uffff\1\54\1\uffff\1\54\1\uffff\5\54\1\uffff\1\76\1\100\3\uffff\3\54\1\106\3\uffff\1\110\2\uffff\1\113\2\54\1\121\2\54\2\uffff\2\54\1\uffff\2\54\3\uffff\1\133\3\uffff\10\54\1\153\6\54\4\uffff\1\163\3\54\7\uffff\4\54\2\uffff\1\54\1\174\5\54\1\53\1\u0086\3\uffff\15\54\1\uffff\3\54\1\u009a\3\54\1\uffff\1\u009e\1\54\1\u00a0\1\54\1\u00a2\3\54\1\uffff\5\54\1\u00ae\1\u0086\1\uffff\1\u0086\1\uffff\1\133\1\54\1\u00b5\20\54\1\uffff\3\54\1\uffff\1\54\1\uffff\1\u00cb\1\uffff\1\u00cc\1\54\1\u00ce\3\54\1\u00d2\1\54\1\u00ae\1\uffff\1\u00ae\1\uffff\4\u0086\1\uffff\1\54\1\uffff\11\54\1\u00e6\1\54\1\u00e8\1\54\1\u00ea\7\54\2\uffff\1\54\1\uffff\1\u00f3\1\54\1\u00f5\1\uffff\1\54\4\u00ae\1\uffff\2\u0086\1\u00b3\1\54\1\u00fb\4\54\1\u0100\1\54\1\u0103\1\54\1\uffff\1\54\1\uffff\1\54\1\uffff\10\54\1\uffff\1\54\1\uffff\1\u0110\3\u00ae\1\u0111\1\uffff\3\54\1\u0115\1\uffff\1\54\1\u0117\1\uffff\1\54\1\u0119\5\54\1\u011f\3\54\1\u0123\2\uffff\1\u0125\1\u0126\1\54\1\uffff\1\54\1\uffff\1\54\1\uffff\3\54\1\u012d\1\u012e\1\uffff\3\54\1\uffff\1\u0132\2\uffff\1\u0133\5\54\2\uffff\1\u0139\1\54\1\u013b\2\uffff\1\u013c\1\54\1\u013e\2\54\1\uffff\1\54\2\uffff\1\54\1\uffff\1\54\1\u0144\1\54\1\u0146\1\54\1\uffff\1\u0148\1\uffff\1\54\1\uffff\1\u014a\1\uffff";
    static final String DFA45_eofS =
        "\u014b\uffff";
    static final String DFA45_minS =
        "\1\11\1\141\1\uffff\1\154\1\uffff\1\145\1\165\1\155\1\156\1\165\1\uffff\1\76\1\75\3\uffff\1\162\1\157\1\141\1\72\3\uffff\1\56\2\uffff\1\55\2\145\1\75\1\157\1\141\2\uffff\1\151\1\157\1\uffff\1\141\1\162\1\0\1\175\1\uffff\1\56\3\uffff\1\143\1\141\1\164\1\155\1\141\1\155\1\143\1\145\1\60\1\160\1\163\1\141\1\147\1\160\1\141\4\uffff\1\60\1\164\1\162\1\154\7\uffff\1\154\1\164\1\157\1\146\2\uffff\1\165\1\60\1\154\1\156\1\144\1\166\1\162\1\47\1\0\1\uffff\1\60\1\uffff\1\153\1\156\1\150\1\163\1\160\1\151\1\141\1\154\1\164\1\162\1\165\2\157\1\uffff\1\154\1\165\1\154\1\60\1\165\1\154\1\162\1\uffff\1\60\1\151\1\60\1\146\1\60\1\164\2\145\1\uffff\1\163\1\144\1\145\1\141\1\157\4\0\1\uffff\1\56\1\141\1\60\1\157\1\162\1\164\1\157\1\155\1\163\1\151\2\141\1\151\1\164\1\143\1\60\1\145\1\155\1\171\1\uffff\1\155\1\151\1\141\1\uffff\1\146\1\uffff\1\60\1\uffff\1\60\1\162\1\60\1\145\1\151\1\163\1\60\1\162\3\0\1\uffff\4\0\1\uffff\1\147\1\uffff\1\156\2\141\1\156\1\164\1\163\1\151\1\156\1\162\1\60\1\145\1\60\1\141\1\60\1\155\1\160\1\163\2\145\1\156\1\151\2\uffff\1\145\1\uffff\1\60\1\156\1\60\1\uffff\1\60\4\0\1\uffff\3\0\1\145\1\60\1\143\1\156\2\145\1\60\1\146\1\60\1\141\1\uffff\1\163\1\uffff\1\164\1\uffff\1\145\1\164\1\151\1\156\1\163\1\164\1\143\1\156\1\uffff\1\147\1\uffff\1\60\3\0\1\60\1\uffff\2\164\1\156\1\60\1\uffff\1\151\1\60\1\uffff\1\164\1\60\1\151\1\156\1\151\1\163\1\164\1\60\1\145\1\141\1\143\1\60\2\uffff\2\60\1\164\1\uffff\1\145\1\uffff\1\151\1\uffff\1\157\1\164\1\157\2\60\1\uffff\1\145\1\164\1\145\1\uffff\1\60\2\uffff\1\60\1\162\1\157\1\156\1\141\1\156\2\uffff\1\60\1\151\1\60\2\uffff\1\60\1\156\1\60\1\164\1\163\1\uffff\1\157\2\uffff\1\163\1\uffff\1\151\1\60\1\156\1\60\1\157\1\uffff\1\60\1\uffff\1\156\1\uffff\1\60\1\uffff";
    static final String DFA45_maxS =
        "\1\175\1\171\1\uffff\1\157\1\uffff\1\157\1\165\1\156\1\163\1\165\1\uffff\1\76\1\75\3\uffff\1\162\1\157\1\145\1\72\3\uffff\1\56\2\uffff\1\76\1\155\1\157\1\75\1\162\1\141\2\uffff\1\151\1\157\1\uffff\1\141\1\162\1\uffff\1\175\1\uffff\1\137\3\uffff\1\143\1\141\1\164\1\156\1\141\1\155\1\154\1\145\1\172\1\160\1\163\1\144\1\147\1\160\1\141\4\uffff\1\172\1\164\1\162\1\154\7\uffff\1\154\1\164\1\157\1\146\2\uffff\1\165\1\172\1\154\1\156\1\144\1\166\1\162\1\47\1\uffff\1\uffff\1\71\1\uffff\1\153\1\156\1\150\1\164\1\160\1\163\1\141\1\154\1\164\1\162\1\165\2\157\1\uffff\1\154\1\165\1\154\1\172\1\165\1\154\1\162\1\uffff\1\172\1\151\1\172\1\146\1\172\1\164\2\145\1\uffff\1\163\1\144\1\145\1\141\1\157\4\uffff\1\uffff\1\137\1\141\1\172\1\157\1\162\1\164\1\165\1\155\1\163\1\151\2\141\1\151\1\164\1\143\1\60\1\145\1\155\1\171\1\uffff\1\155\1\151\1\141\1\uffff\1\146\1\uffff\1\172\1\uffff\1\172\1\162\1\172\1\145\1\151\1\163\1\172\1\162\3\uffff\1\uffff\4\uffff\1\uffff\1\147\1\uffff\1\156\2\141\1\156\1\164\1\163\1\151\1\156\1\162\1\172\1\145\1\172\1\141\1\172\1\155\1\160\1\163\2\145\1\156\1\151\2\uffff\1\145\1\uffff\1\172\1\156\1\172\1\uffff\1\60\4\uffff\1\uffff\3\uffff\1\145\1\172\1\143\1\156\2\145\1\172\1\146\1\172\1\141\1\uffff\1\163\1\uffff\1\164\1\uffff\1\145\1\164\1\151\1\156\1\163\1\164\1\143\1\156\1\uffff\1\147\1\uffff\1\172\3\uffff\1\172\1\uffff\2\164\1\156\1\172\1\uffff\1\151\1\172\1\uffff\1\164\1\172\1\151\1\156\1\151\1\163\1\164\1\172\1\145\1\141\1\143\1\172\2\uffff\2\172\1\164\1\uffff\1\145\1\uffff\1\151\1\uffff\1\157\1\164\1\157\2\172\1\uffff\1\145\1\164\1\145\1\uffff\1\172\2\uffff\1\172\1\162\1\157\1\156\1\141\1\156\2\uffff\1\172\1\151\1\172\2\uffff\1\172\1\156\1\172\1\164\1\163\1\uffff\1\157\2\uffff\1\163\1\uffff\1\151\1\172\1\156\1\172\1\157\1\uffff\1\172\1\uffff\1\156\1\uffff\1\172\1\uffff";
    static final String DFA45_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\5\uffff\1\14\2\uffff\1\24\1\25\1\26\4\uffff\1\41\1\42\1\43\1\uffff\1\46\1\47\6\uffff\1\61\1\62\2\uffff\1\76\4\uffff\1\110\1\uffff\1\114\1\115\1\116\17\uffff\1\15\1\40\1\16\1\45\4\uffff\1\53\1\34\1\67\1\44\1\50\1\111\1\66\4\uffff\1\54\1\65\11\uffff\1\113\1\uffff\1\112\15\uffff\1\73\7\uffff\1\27\10\uffff\1\72\11\uffff\1\107\23\uffff\1\23\3\uffff\1\30\1\uffff\1\37\1\uffff\1\101\13\uffff\1\104\4\uffff\1\106\1\uffff\1\32\25\uffff\1\51\1\52\1\uffff\1\56\3\uffff\1\100\5\uffff\1\105\15\uffff\1\70\1\uffff\1\7\1\uffff\1\103\10\uffff\1\57\1\uffff\1\75\5\uffff\1\77\4\uffff\1\35\2\uffff\1\21\14\uffff\1\102\1\1\3\uffff\1\63\1\uffff\1\5\1\uffff\1\6\5\uffff\1\71\3\uffff\1\74\1\uffff\1\3\1\55\6\uffff\1\13\1\17\3\uffff\1\36\1\33\5\uffff\1\11\1\uffff\1\60\1\64\1\uffff\1\12\5\uffff\1\10\1\uffff\1\22\1\uffff\1\31\1\uffff\1\20";
    static final String DFA45_specialS =
        "\47\uffff\1\10\62\uffff\1\22\47\uffff\1\3\1\5\1\14\1\1\45\uffff\1\23\1\13\1\21\1\uffff\1\7\1\11\1\25\1\0\41\uffff\1\12\1\4\1\17\1\20\1\uffff\1\6\1\24\1\26\33\uffff\1\2\1\16\1\15\121\uffff}>";
    static final String[] DFA45_transitionS = {
            "\2\55\2\uffff\1\55\22\uffff\1\55\1\26\1\53\1\31\1\50\1\uffff\1\25\1\47\1\15\1\17\1\44\1\35\1\16\1\32\1\27\1\uffff\12\52\1\23\1\2\1\14\1\13\1\30\2\uffff\32\54\1\40\1\uffff\1\41\2\uffff\1\51\1\10\1\42\1\3\1\5\1\46\1\37\1\11\1\54\1\7\1\45\2\54\1\43\1\21\1\20\1\1\1\6\1\34\1\33\1\36\1\54\1\22\4\54\1\4\1\24\1\12",
            "\1\56\12\uffff\1\57\14\uffff\1\60",
            "",
            "\1\62\2\uffff\1\61",
            "",
            "\1\64\11\uffff\1\63",
            "\1\65",
            "\1\67\1\66",
            "\1\71\1\uffff\1\73\1\uffff\1\72\1\70",
            "\1\74",
            "",
            "\1\75",
            "\1\77",
            "",
            "",
            "",
            "\1\101",
            "\1\102",
            "\1\104\3\uffff\1\103",
            "\1\105",
            "",
            "",
            "",
            "\1\107",
            "",
            "",
            "\1\112\20\uffff\1\111",
            "\1\114\7\uffff\1\115",
            "\1\117\11\uffff\1\116",
            "\1\120",
            "\1\123\2\uffff\1\122",
            "\1\124",
            "",
            "",
            "\1\125",
            "\1\126",
            "",
            "\1\127",
            "\1\130",
            "\47\53\1\131\uffd8\53",
            "\1\132",
            "",
            "\1\135\1\uffff\12\52\45\uffff\1\134",
            "",
            "",
            "",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\142\1\141",
            "\1\143",
            "\1\144",
            "\1\145\10\uffff\1\146",
            "\1\147",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\5\54\1\152\11\54\1\150\5\54\1\151\4\54",
            "\1\154",
            "\1\155",
            "\1\156\2\uffff\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "",
            "",
            "",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\164",
            "\1\165",
            "\1\166",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "",
            "",
            "\1\173",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\44\u0085\1\u0084\2\u0085\1\u0083\uffd8\u0085",
            "",
            "\12\u0087",
            "",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008c\1\u008b",
            "\1\u008d",
            "\1\u008e\11\uffff\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u009f",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00a1",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\44\u00ad\1\u00ac\2\u00ad\1\u00ab\uffd8\u00ad",
            "\44\u00b1\1\u00b0\2\u00b1\1\u00af\uffd8\u00b1",
            "\173\u00b2\1\u00b3\uff84\u00b2",
            "\44\u0085\1\u0084\2\u0085\1\u0083\uffd8\u0085",
            "",
            "\1\135\1\uffff\12\u0087\45\uffff\1\134",
            "\1\u00b4",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9\5\uffff\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "",
            "\1\u00ca",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00cd",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00d3",
            "\44\u00d6\1\u00d5\2\u00d6\1\u00d4\uffd8\u00d6",
            "\173\u00d7\1\u00d8\uff84\u00d7",
            "\44\u00ad\1\u00ac\2\u00ad\1\u00ab\uffd8\u00ad",
            "",
            "\44\u00da\1\u00d9\2\u00da\1\uffff\uffd8\u00da",
            "\44\u0085\1\u0084\2\u0085\1\u0083\123\u0085\1\u00db\uff84\u0085",
            "\44\u0085\1\u0084\2\u0085\1\u0083\uffd8\u0085",
            "\44\u0085\1\u0084\2\u0085\1\u0083\uffd8\u0085",
            "",
            "\1\u00dc",
            "",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00e7",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00e9",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "",
            "",
            "\1\u00f2",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00f4",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u00f6",
            "\44\u00f8\1\u00f7\2\u00f8\1\uffff\uffd8\u00f8",
            "\44\u00ad\1\u00ac\2\u00ad\1\u00ab\123\u00ad\1\u00f9\uff84\u00ad",
            "\44\u00ad\1\u00ac\2\u00ad\1\u00ab\uffd8\u00ad",
            "\44\u00ad\1\u00ac\2\u00ad\1\u00ab\uffd8\u00ad",
            "",
            "\44\u0085\1\u0084\2\u0085\1\u0083\123\u0085\1\u00db\uff84\u0085",
            "\44\u0085\1\u0084\2\u0085\1\u0083\uffd8\u0085",
            "\44\u0085\1\u0084\2\u0085\1\u0083\uffd8\u0085",
            "\1\u00fa",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0101",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\22\54\1\u0102\7\54",
            "\1\u0104",
            "",
            "\1\u0105",
            "",
            "\1\u0106",
            "",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "",
            "\1\u010f",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\44\u00ad\1\u00ac\2\u00ad\1\u00ab\123\u00ad\1\u00f9\uff84\u00ad",
            "\44\u00ad\1\u00ac\2\u00ad\1\u00ab\uffd8\u00ad",
            "\44\u00ad\1\u00ac\2\u00ad\1\u00ab\uffd8\u00ad",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u0116",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u0118",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\22\54\1\u0124\7\54",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0127",
            "",
            "\1\u0128",
            "",
            "\1\u0129",
            "",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u013a",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u013d",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u013f",
            "\1\u0140",
            "",
            "\1\u0141",
            "",
            "",
            "\1\u0142",
            "",
            "\1\u0143",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0145",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0147",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\u0149",
            "",
            "\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            ""
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | RULE_ISTRING_TEXT | RULE_ISTRING_LEFT | RULE_ISTRING_MIDDLE | RULE_ISTRING_RIGHT | RULE_SSTRING | RULE_SL_COMMENT | RULE_REAL_LIT | RULE_INTEGER_LIT | RULE_STRING | RULE_ID | RULE_WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_178 = input.LA(1);

                        s = -1;
                        if ( (LA45_178=='\'') ) {s = 131;}

                        else if ( (LA45_178=='$') ) {s = 132;}

                        else if ( ((LA45_178>='\u0000' && LA45_178<='#')||(LA45_178>='%' && LA45_178<='&')||(LA45_178>='(' && LA45_178<='\uFFFF')) ) {s = 133;}

                        else s = 134;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA45_133 = input.LA(1);

                        s = -1;
                        if ( (LA45_133=='\'') ) {s = 131;}

                        else if ( (LA45_133=='$') ) {s = 132;}

                        else if ( ((LA45_133>='\u0000' && LA45_133<='#')||(LA45_133>='%' && LA45_133<='&')||(LA45_133>='(' && LA45_133<='\uFFFF')) ) {s = 133;}

                        else s = 134;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA45_247 = input.LA(1);

                        s = -1;
                        if ( (LA45_247=='{') ) {s = 249;}

                        else if ( (LA45_247=='\'') ) {s = 171;}

                        else if ( (LA45_247=='$') ) {s = 172;}

                        else if ( ((LA45_247>='\u0000' && LA45_247<='#')||(LA45_247>='%' && LA45_247<='&')||(LA45_247>='(' && LA45_247<='z')||(LA45_247>='|' && LA45_247<='\uFFFF')) ) {s = 173;}

                        else s = 174;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA45_130 = input.LA(1);

                        s = -1;
                        if ( (LA45_130=='\'') ) {s = 171;}

                        else if ( (LA45_130=='$') ) {s = 172;}

                        else if ( ((LA45_130>='\u0000' && LA45_130<='#')||(LA45_130>='%' && LA45_130<='&')||(LA45_130>='(' && LA45_130<='\uFFFF')) ) {s = 173;}

                        else s = 174;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA45_213 = input.LA(1);

                        s = -1;
                        if ( (LA45_213=='{') ) {s = 249;}

                        else if ( (LA45_213=='\'') ) {s = 171;}

                        else if ( (LA45_213=='$') ) {s = 172;}

                        else if ( ((LA45_213>='\u0000' && LA45_213<='#')||(LA45_213>='%' && LA45_213<='&')||(LA45_213>='(' && LA45_213<='z')||(LA45_213>='|' && LA45_213<='\uFFFF')) ) {s = 173;}

                        else s = 174;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA45_131 = input.LA(1);

                        s = -1;
                        if ( (LA45_131=='\'') ) {s = 175;}

                        else if ( (LA45_131=='$') ) {s = 176;}

                        else if ( ((LA45_131>='\u0000' && LA45_131<='#')||(LA45_131>='%' && LA45_131<='&')||(LA45_131>='(' && LA45_131<='\uFFFF')) ) {s = 177;}

                        else s = 134;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA45_217 = input.LA(1);

                        s = -1;
                        if ( (LA45_217=='{') ) {s = 219;}

                        else if ( (LA45_217=='\'') ) {s = 131;}

                        else if ( (LA45_217=='$') ) {s = 132;}

                        else if ( ((LA45_217>='\u0000' && LA45_217<='#')||(LA45_217>='%' && LA45_217<='&')||(LA45_217>='(' && LA45_217<='z')||(LA45_217>='|' && LA45_217<='\uFFFF')) ) {s = 133;}

                        else s = 134;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA45_175 = input.LA(1);

                        s = -1;
                        if ( (LA45_175=='$') ) {s = 217;}

                        else if ( ((LA45_175>='\u0000' && LA45_175<='#')||(LA45_175>='%' && LA45_175<='&')||(LA45_175>='(' && LA45_175<='\uFFFF')) ) {s = 218;}

                        else s = 134;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA45_39 = input.LA(1);

                        s = -1;
                        if ( (LA45_39=='\'') ) {s = 89;}

                        else if ( ((LA45_39>='\u0000' && LA45_39<='&')||(LA45_39>='(' && LA45_39<='\uFFFF')) ) {s = 43;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA45_176 = input.LA(1);

                        s = -1;
                        if ( (LA45_176=='{') ) {s = 219;}

                        else if ( (LA45_176=='\'') ) {s = 131;}

                        else if ( (LA45_176=='$') ) {s = 132;}

                        else if ( ((LA45_176>='\u0000' && LA45_176<='#')||(LA45_176>='%' && LA45_176<='&')||(LA45_176>='(' && LA45_176<='z')||(LA45_176>='|' && LA45_176<='\uFFFF')) ) {s = 133;}

                        else s = 134;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA45_212 = input.LA(1);

                        s = -1;
                        if ( (LA45_212=='$') ) {s = 247;}

                        else if ( ((LA45_212>='\u0000' && LA45_212<='#')||(LA45_212>='%' && LA45_212<='&')||(LA45_212>='(' && LA45_212<='\uFFFF')) ) {s = 248;}

                        else s = 174;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA45_172 = input.LA(1);

                        s = -1;
                        if ( ((LA45_172>='\u0000' && LA45_172<='z')||(LA45_172>='|' && LA45_172<='\uFFFF')) ) {s = 215;}

                        else if ( (LA45_172=='{') ) {s = 216;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA45_132 = input.LA(1);

                        s = -1;
                        if ( ((LA45_132>='\u0000' && LA45_132<='z')||(LA45_132>='|' && LA45_132<='\uFFFF')) ) {s = 178;}

                        else if ( (LA45_132=='{') ) {s = 179;}

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA45_249 = input.LA(1);

                        s = -1;
                        if ( (LA45_249=='\'') ) {s = 171;}

                        else if ( (LA45_249=='$') ) {s = 172;}

                        else if ( ((LA45_249>='\u0000' && LA45_249<='#')||(LA45_249>='%' && LA45_249<='&')||(LA45_249>='(' && LA45_249<='\uFFFF')) ) {s = 173;}

                        else s = 174;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA45_248 = input.LA(1);

                        s = -1;
                        if ( (LA45_248=='\'') ) {s = 171;}

                        else if ( (LA45_248=='$') ) {s = 172;}

                        else if ( ((LA45_248>='\u0000' && LA45_248<='#')||(LA45_248>='%' && LA45_248<='&')||(LA45_248>='(' && LA45_248<='\uFFFF')) ) {s = 173;}

                        else s = 174;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA45_214 = input.LA(1);

                        s = -1;
                        if ( (LA45_214=='\'') ) {s = 171;}

                        else if ( (LA45_214=='$') ) {s = 172;}

                        else if ( ((LA45_214>='\u0000' && LA45_214<='#')||(LA45_214>='%' && LA45_214<='&')||(LA45_214>='(' && LA45_214<='\uFFFF')) ) {s = 173;}

                        else s = 174;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA45_215 = input.LA(1);

                        s = -1;
                        if ( (LA45_215=='\'') ) {s = 171;}

                        else if ( (LA45_215=='$') ) {s = 172;}

                        else if ( ((LA45_215>='\u0000' && LA45_215<='#')||(LA45_215>='%' && LA45_215<='&')||(LA45_215>='(' && LA45_215<='\uFFFF')) ) {s = 173;}

                        else s = 174;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA45_173 = input.LA(1);

                        s = -1;
                        if ( (LA45_173=='\'') ) {s = 171;}

                        else if ( (LA45_173=='$') ) {s = 172;}

                        else if ( ((LA45_173>='\u0000' && LA45_173<='#')||(LA45_173>='%' && LA45_173<='&')||(LA45_173>='(' && LA45_173<='\uFFFF')) ) {s = 173;}

                        else s = 174;

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA45_90 = input.LA(1);

                        s = -1;
                        if ( (LA45_90=='\'') ) {s = 131;}

                        else if ( (LA45_90=='$') ) {s = 132;}

                        else if ( ((LA45_90>='\u0000' && LA45_90<='#')||(LA45_90>='%' && LA45_90<='&')||(LA45_90>='(' && LA45_90<='\uFFFF')) ) {s = 133;}

                        else s = 134;

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA45_171 = input.LA(1);

                        s = -1;
                        if ( (LA45_171=='\'') ) {s = 212;}

                        else if ( (LA45_171=='$') ) {s = 213;}

                        else if ( ((LA45_171>='\u0000' && LA45_171<='#')||(LA45_171>='%' && LA45_171<='&')||(LA45_171>='(' && LA45_171<='\uFFFF')) ) {s = 214;}

                        else s = 174;

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA45_218 = input.LA(1);

                        s = -1;
                        if ( (LA45_218=='\'') ) {s = 131;}

                        else if ( (LA45_218=='$') ) {s = 132;}

                        else if ( ((LA45_218>='\u0000' && LA45_218<='#')||(LA45_218>='%' && LA45_218<='&')||(LA45_218>='(' && LA45_218<='\uFFFF')) ) {s = 133;}

                        else s = 134;

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA45_177 = input.LA(1);

                        s = -1;
                        if ( (LA45_177=='\'') ) {s = 131;}

                        else if ( (LA45_177=='$') ) {s = 132;}

                        else if ( ((LA45_177>='\u0000' && LA45_177<='#')||(LA45_177>='%' && LA45_177<='&')||(LA45_177>='(' && LA45_177<='\uFFFF')) ) {s = 133;}

                        else s = 134;

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA45_219 = input.LA(1);

                        s = -1;
                        if ( (LA45_219=='\'') ) {s = 131;}

                        else if ( (LA45_219=='$') ) {s = 132;}

                        else if ( ((LA45_219>='\u0000' && LA45_219<='#')||(LA45_219>='%' && LA45_219<='&')||(LA45_219>='(' && LA45_219<='\uFFFF')) ) {s = 133;}

                        else s = 179;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 45, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}