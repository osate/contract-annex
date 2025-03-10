package org.osate.sysmlv2.contract.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContractLexer extends Lexer {
    public static final int T__50=50;
    public static final int RULE_ISTRING_TEXT=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_ISTRING_RIGHT=10;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_SSTRING=5;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_ISTRING_MIDDLE=9;
    public static final int T__33=33;
    public static final int RULE_IN_ISTRING=11;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int RULE_ISTRING_LEFT=8;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:11:7: ( 'invocation' )
            // InternalContract.g:11:9: 'invocation'
            {
            match("invocation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:12:7: ( 'analysis' )
            // InternalContract.g:12:9: 'analysis'
            {
            match("analysis"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:13:7: ( '=>' )
            // InternalContract.g:13:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:14:7: ( 'python' )
            // InternalContract.g:14:9: 'python'
            {
            match("python"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:15:7: ( 'java' )
            // InternalContract.g:15:9: 'java'
            {
            match("java"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:16:7: ( 'smt' )
            // InternalContract.g:16:9: 'smt'
            {
            match("smt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:17:7: ( 'error0' )
            // InternalContract.g:17:9: 'error0'
            {
            match("error0"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:18:7: ( 'info0' )
            // InternalContract.g:18:9: 'info0'
            {
            match("info0"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:19:7: ( 'package' )
            // InternalContract.g:19:9: 'package'
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
            // InternalContract.g:20:7: ( ';' )
            // InternalContract.g:20:9: ';'
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
            // InternalContract.g:21:7: ( 'contract' )
            // InternalContract.g:21:9: 'contract'
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
            // InternalContract.g:22:7: ( '{' )
            // InternalContract.g:22:9: '{'
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
            // InternalContract.g:23:7: ( '}' )
            // InternalContract.g:23:9: '}'
            {
            match('}'); 

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
            // InternalContract.g:24:7: ( 'domains' )
            // InternalContract.g:24:9: 'domains'
            {
            match("domains"); 


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
            // InternalContract.g:25:7: ( 'queries' )
            // InternalContract.g:25:9: 'queries'
            {
            match("queries"); 


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
            // InternalContract.g:26:7: ( 'input' )
            // InternalContract.g:26:9: 'input'
            {
            match("input"); 


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
            // InternalContract.g:27:7: ( 'assumptions' )
            // InternalContract.g:27:9: 'assumptions'
            {
            match("assumptions"); 


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
            // InternalContract.g:28:7: ( 'guarantee' )
            // InternalContract.g:28:9: 'guarantee'
            {
            match("guarantee"); 


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
            // InternalContract.g:29:7: ( 'argument' )
            // InternalContract.g:29:9: 'argument'
            {
            match("argument"); 


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
            // InternalContract.g:30:7: ( 'implementation' )
            // InternalContract.g:30:9: 'implementation'
            {
            match("implementation"); 


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
            // InternalContract.g:31:7: ( 'domain' )
            // InternalContract.g:31:9: 'domain'
            {
            match("domain"); 


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
            // InternalContract.g:32:7: ( 'declarations' )
            // InternalContract.g:32:9: 'declarations'
            {
            match("declarations"); 


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
            // InternalContract.g:33:7: ( 'and' )
            // InternalContract.g:33:9: 'and'
            {
            match("and"); 


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
            // InternalContract.g:34:7: ( '(' )
            // InternalContract.g:34:9: '('
            {
            match('('); 

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
            // InternalContract.g:35:7: ( ')' )
            // InternalContract.g:35:9: ')'
            {
            match(')'); 

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
            // InternalContract.g:36:7: ( ',' )
            // InternalContract.g:36:9: ','
            {
            match(','); 

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
            // InternalContract.g:37:7: ( 'or' )
            // InternalContract.g:37:9: 'or'
            {
            match("or"); 


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
            // InternalContract.g:38:7: ( 'not' )
            // InternalContract.g:38:9: 'not'
            {
            match("not"); 


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
            // InternalContract.g:39:7: ( 'verification' )
            // InternalContract.g:39:9: 'verification'
            {
            match("verification"); 


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
            // InternalContract.g:40:7: ( 'plan' )
            // InternalContract.g:40:9: 'plan'
            {
            match("plan"); 


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
            // InternalContract.g:41:7: ( 'component' )
            // InternalContract.g:41:9: 'component'
            {
            match("component"); 


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
            // InternalContract.g:42:7: ( ':' )
            // InternalContract.g:42:9: ':'
            {
            match(':'); 

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
            // InternalContract.g:43:7: ( 'claims' )
            // InternalContract.g:43:9: 'claims'
            {
            match("claims"); 


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
            // InternalContract.g:44:7: ( 'contracts' )
            // InternalContract.g:44:9: 'contracts'
            {
            match("contracts"); 


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
            // InternalContract.g:45:7: ( 'val' )
            // InternalContract.g:45:9: 'val'
            {
            match("val"); 


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
            // InternalContract.g:46:7: ( '=' )
            // InternalContract.g:46:9: '='
            {
            match('='); 

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
            // InternalContract.g:47:7: ( '||' )
            // InternalContract.g:47:9: '||'
            {
            match("||"); 


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
            // InternalContract.g:48:7: ( '&&' )
            // InternalContract.g:48:9: '&&'
            {
            match("&&"); 


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
            // InternalContract.g:49:7: ( '!' )
            // InternalContract.g:49:9: '!'
            {
            match('!'); 

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
            // InternalContract.g:50:7: ( '.' )
            // InternalContract.g:50:9: '.'
            {
            match('.'); 

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
            // InternalContract.g:51:7: ( '<' )
            // InternalContract.g:51:9: '<'
            {
            match('<'); 

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
            // InternalContract.g:52:7: ( '>' )
            // InternalContract.g:52:9: '>'
            {
            match('>'); 

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
            // InternalContract.g:53:7: ( '#' )
            // InternalContract.g:53:9: '#'
            {
            match('#'); 

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
            // InternalContract.g:54:7: ( '->' )
            // InternalContract.g:54:9: '->'
            {
            match("->"); 


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
            // InternalContract.g:55:7: ( 'self' )
            // InternalContract.g:55:9: 'self'
            {
            match("self"); 


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
            // InternalContract.g:56:7: ( '::' )
            // InternalContract.g:56:9: '::'
            {
            match("::"); 


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
            // InternalContract.g:57:7: ( '<=>' )
            // InternalContract.g:57:9: '<=>'
            {
            match("<=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "RULE_ISTRING_TEXT"
    public final void mRULE_ISTRING_TEXT() throws RecognitionException {
        try {
            int _type = RULE_ISTRING_TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:8816:19: ( '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // InternalContract.g:8816:21: '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match("'''"); 

            // InternalContract.g:8816:30: ( RULE_IN_ISTRING )*
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
            	    // InternalContract.g:8816:30: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalContract.g:8816:47: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
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
                    // InternalContract.g:8816:48: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // InternalContract.g:8816:57: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // InternalContract.g:8816:57: ( '\\'' ( '\\'' )? )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\'') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalContract.g:8816:58: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // InternalContract.g:8816:63: ( '\\'' )?
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( (LA2_0=='\'') ) {
                                alt2=1;
                            }
                            switch (alt2) {
                                case 1 :
                                    // InternalContract.g:8816:63: '\\''
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
            // InternalContract.g:8818:19: ( '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${' )
            // InternalContract.g:8818:21: '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${'
            {
            match("'''"); 

            // InternalContract.g:8818:30: ( RULE_IN_ISTRING )*
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
            	    // InternalContract.g:8818:30: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalContract.g:8818:47: ( '\\'' ( '\\'' )? )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\'') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalContract.g:8818:48: '\\'' ( '\\'' )?
                    {
                    match('\''); 
                    // InternalContract.g:8818:53: ( '\\'' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\'') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalContract.g:8818:53: '\\''
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
            // InternalContract.g:8820:21: ( '$}' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${' )
            // InternalContract.g:8820:23: '$}' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${'
            {
            match("$}"); 

            // InternalContract.g:8820:28: ( RULE_IN_ISTRING )*
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
            	    // InternalContract.g:8820:28: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalContract.g:8820:45: ( '\\'' ( '\\'' )? )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\'') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalContract.g:8820:46: '\\'' ( '\\'' )?
                    {
                    match('\''); 
                    // InternalContract.g:8820:51: ( '\\'' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\'') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalContract.g:8820:51: '\\''
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
            // InternalContract.g:8822:20: ( '$}' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // InternalContract.g:8822:22: '$}' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match("$}"); 

            // InternalContract.g:8822:27: ( RULE_IN_ISTRING )*
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
            	    // InternalContract.g:8822:27: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalContract.g:8822:44: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
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
                    // InternalContract.g:8822:45: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // InternalContract.g:8822:54: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // InternalContract.g:8822:54: ( '\\'' ( '\\'' )? )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\'') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalContract.g:8822:55: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // InternalContract.g:8822:60: ( '\\'' )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0=='\'') ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // InternalContract.g:8822:60: '\\''
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
            // InternalContract.g:8824:26: ( ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | '$' ~ ( '{' ) | ~ ( ( '\\'' | '$' ) ) ) )
            // InternalContract.g:8824:28: ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | '$' ~ ( '{' ) | ~ ( ( '\\'' | '$' ) ) )
            {
            // InternalContract.g:8824:28: ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | '$' ~ ( '{' ) | ~ ( ( '\\'' | '$' ) ) )
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
                    // InternalContract.g:8824:29: '\\'\\'' ~ ( '\\'' )
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
                    // InternalContract.g:8824:44: '\\'' ~ ( '\\'' )
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
                    // InternalContract.g:8824:57: '$' ~ ( '{' )
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
                    // InternalContract.g:8824:68: ~ ( ( '\\'' | '$' ) )
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
            // InternalContract.g:8826:14: ( '`' (~ ( '`' ) )* '`' )
            // InternalContract.g:8826:16: '`' (~ ( '`' ) )* '`'
            {
            match('`'); 
            // InternalContract.g:8826:20: (~ ( '`' ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='_')||(LA16_0>='a' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalContract.g:8826:20: ~ ( '`' )
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
            // InternalContract.g:8828:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalContract.g:8828:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // InternalContract.g:8828:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalContract.g:8828:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalContract.g:8828:40: ( ( '\\r' )? '\\n' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\n'||LA19_0=='\r') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalContract.g:8828:41: ( '\\r' )? '\\n'
                    {
                    // InternalContract.g:8828:41: ( '\\r' )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='\r') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalContract.g:8828:41: '\\r'
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

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:8830:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalContract.g:8830:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalContract.g:8830:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\"') ) {
                alt22=1;
            }
            else if ( (LA22_0=='\'') ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalContract.g:8830:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalContract.g:8830:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop20:
                    do {
                        int alt20=3;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='\\') ) {
                            alt20=1;
                        }
                        else if ( ((LA20_0>='\u0000' && LA20_0<='!')||(LA20_0>='#' && LA20_0<='[')||(LA20_0>=']' && LA20_0<='\uFFFF')) ) {
                            alt20=2;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalContract.g:8830:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // InternalContract.g:8830:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop20;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalContract.g:8830:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalContract.g:8830:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop21:
                    do {
                        int alt21=3;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0=='\\') ) {
                            alt21=1;
                        }
                        else if ( ((LA21_0>='\u0000' && LA21_0<='&')||(LA21_0>='(' && LA21_0<='[')||(LA21_0>=']' && LA21_0<='\uFFFF')) ) {
                            alt21=2;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalContract.g:8830:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // InternalContract.g:8830:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop21;
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
            // InternalContract.g:8832:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )* )
            // InternalContract.g:8832:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalContract.g:8832:31: ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='0' && LA24_0<='9')||(LA24_0>='A' && LA24_0<='Z')||LA24_0=='_'||(LA24_0>='a' && LA24_0<='z')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalContract.g:8832:32: ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
            	    {
            	    // InternalContract.g:8832:32: ( '_' )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0=='_') ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // InternalContract.g:8832:32: '_'
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
            	    break loop24;
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

    public void mTokens() throws RecognitionException {
        // InternalContract.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | RULE_ISTRING_TEXT | RULE_ISTRING_LEFT | RULE_ISTRING_MIDDLE | RULE_ISTRING_RIGHT | RULE_SSTRING | RULE_SL_COMMENT | RULE_STRING | RULE_ID )
        int alt25=55;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // InternalContract.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalContract.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalContract.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalContract.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalContract.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalContract.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalContract.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalContract.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalContract.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalContract.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalContract.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalContract.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalContract.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalContract.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalContract.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalContract.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalContract.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalContract.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalContract.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalContract.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalContract.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalContract.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalContract.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalContract.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalContract.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalContract.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalContract.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalContract.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalContract.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalContract.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalContract.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalContract.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalContract.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalContract.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalContract.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalContract.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalContract.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalContract.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalContract.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // InternalContract.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // InternalContract.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // InternalContract.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // InternalContract.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // InternalContract.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // InternalContract.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // InternalContract.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // InternalContract.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // InternalContract.g:1:292: RULE_ISTRING_TEXT
                {
                mRULE_ISTRING_TEXT(); 

                }
                break;
            case 49 :
                // InternalContract.g:1:310: RULE_ISTRING_LEFT
                {
                mRULE_ISTRING_LEFT(); 

                }
                break;
            case 50 :
                // InternalContract.g:1:328: RULE_ISTRING_MIDDLE
                {
                mRULE_ISTRING_MIDDLE(); 

                }
                break;
            case 51 :
                // InternalContract.g:1:348: RULE_ISTRING_RIGHT
                {
                mRULE_ISTRING_RIGHT(); 

                }
                break;
            case 52 :
                // InternalContract.g:1:367: RULE_SSTRING
                {
                mRULE_SSTRING(); 

                }
                break;
            case 53 :
                // InternalContract.g:1:380: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 54 :
                // InternalContract.g:1:396: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 55 :
                // InternalContract.g:1:408: RULE_ID
                {
                mRULE_ID(); 

                }
                break;

        }

    }


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\1\uffff\2\42\1\51\4\42\1\uffff\1\42\2\uffff\3\42\3\uffff\3\42\1\74\4\uffff\1\76\10\uffff\5\42\2\uffff\15\42\1\131\3\42\6\uffff\1\41\1\141\5\42\1\147\6\42\1\156\11\42\1\uffff\1\170\1\42\1\172\1\176\1\141\1\uffff\1\141\1\uffff\5\42\1\uffff\4\42\1\u008d\1\u008e\1\uffff\1\u008f\10\42\1\uffff\1\42\1\uffff\1\176\1\uffff\1\176\1\uffff\4\141\1\uffff\1\42\1\u00a2\1\u00a3\6\42\3\uffff\11\42\4\176\1\uffff\2\141\1\u0083\1\42\2\uffff\4\42\1\u00bb\1\42\1\u00bd\2\42\1\u00c0\1\u00c2\4\42\3\176\5\42\1\uffff\1\u00cc\1\uffff\2\42\1\uffff\1\u00cf\1\uffff\1\42\1\u00d1\4\42\1\u00d6\1\42\1\u00d8\1\uffff\1\u00da\1\42\1\uffff\1\42\1\uffff\4\42\1\uffff\1\42\1\uffff\1\u00e2\1\uffff\1\u00e3\1\42\1\u00e5\1\42\1\u00e7\2\42\2\uffff\1\42\1\uffff\1\42\1\uffff\1\42\1\u00ed\3\42\1\uffff\1\u00f1\1\u00f2\1\42\2\uffff\1\u00f4\1\uffff";
    static final String DFA25_eofS =
        "\u00f5\uffff";
    static final String DFA25_minS =
        "\1\41\1\155\1\156\1\76\2\141\1\145\1\162\1\uffff\1\154\2\uffff\1\145\2\165\3\uffff\1\162\1\157\1\141\1\72\4\uffff\1\75\2\uffff\1\55\1\0\1\175\3\uffff\1\146\1\160\1\141\1\163\1\147\2\uffff\1\164\1\143\1\141\1\166\1\164\1\154\1\162\1\155\1\141\1\155\1\143\1\145\1\141\1\60\1\164\1\162\1\154\6\uffff\1\47\1\0\2\157\1\165\2\154\1\60\2\165\1\150\1\153\1\156\1\141\1\60\1\146\1\157\1\164\1\160\1\151\1\141\1\154\2\162\1\uffff\1\60\1\151\1\60\4\0\1\uffff\1\143\1\60\1\164\1\145\1\171\1\uffff\2\155\1\157\1\141\2\60\1\uffff\1\60\2\162\1\157\1\155\1\151\1\141\1\151\1\141\1\uffff\1\146\1\uffff\3\0\1\uffff\4\0\1\uffff\1\141\2\60\1\155\1\163\1\160\1\145\1\156\1\147\3\uffff\1\60\1\141\1\156\1\163\1\156\1\162\1\145\1\156\1\151\4\0\1\uffff\3\0\1\164\2\uffff\1\145\1\151\1\164\1\156\1\60\1\145\1\60\1\143\1\145\2\60\1\141\1\163\1\164\1\143\3\0\1\151\1\156\1\163\1\151\1\164\1\uffff\1\60\1\uffff\1\164\1\156\1\uffff\1\60\1\uffff\1\164\1\60\1\145\1\141\1\157\1\164\1\60\1\157\1\60\1\uffff\1\60\1\164\1\uffff\1\151\1\uffff\1\145\1\164\1\156\1\141\1\uffff\1\156\1\uffff\1\60\1\uffff\1\60\1\157\1\60\1\151\1\60\1\164\1\163\2\uffff\1\156\1\uffff\1\157\1\uffff\1\151\1\60\1\163\1\156\1\157\1\uffff\2\60\1\156\2\uffff\1\60\1\uffff";
    static final String DFA25_maxS =
        "\1\175\1\156\1\163\1\76\1\171\1\141\1\155\1\162\1\uffff\1\157\2\uffff\1\157\2\165\3\uffff\1\162\1\157\1\145\1\72\4\uffff\1\75\2\uffff\1\76\1\uffff\1\175\3\uffff\1\166\1\160\1\144\1\163\1\147\2\uffff\1\164\1\143\1\141\1\166\1\164\1\154\1\162\1\156\1\141\1\155\1\143\1\145\1\141\1\172\1\164\1\162\1\154\6\uffff\1\47\1\uffff\2\157\1\165\2\154\1\172\2\165\1\150\1\153\1\156\1\141\1\172\1\146\1\157\1\164\1\160\1\151\1\141\1\154\2\162\1\uffff\1\172\1\151\1\172\4\uffff\1\uffff\1\143\1\60\1\164\1\145\1\171\1\uffff\2\155\1\157\1\141\2\172\1\uffff\1\172\2\162\1\157\1\155\1\151\1\141\1\151\1\141\1\uffff\1\146\1\uffff\3\uffff\1\uffff\4\uffff\1\uffff\1\141\2\172\1\155\1\163\1\160\1\145\1\156\1\147\3\uffff\1\60\1\141\1\156\1\163\1\156\1\162\1\145\1\156\1\151\4\uffff\1\uffff\3\uffff\1\164\2\uffff\1\145\1\151\1\164\1\156\1\172\1\145\1\172\1\143\1\145\2\172\1\141\1\163\1\164\1\143\3\uffff\1\151\1\156\1\163\1\151\1\164\1\uffff\1\172\1\uffff\1\164\1\156\1\uffff\1\172\1\uffff\1\164\1\172\1\145\1\141\1\157\1\164\1\172\1\157\1\172\1\uffff\1\172\1\164\1\uffff\1\151\1\uffff\1\145\1\164\1\156\1\141\1\uffff\1\156\1\uffff\1\172\1\uffff\1\172\1\157\1\172\1\151\1\172\1\164\1\163\2\uffff\1\156\1\uffff\1\157\1\uffff\1\151\1\172\1\163\1\156\1\157\1\uffff\2\172\1\156\2\uffff\1\172\1\uffff";
    static final String DFA25_acceptS =
        "\10\uffff\1\12\1\uffff\1\14\1\15\3\uffff\1\30\1\31\1\32\4\uffff\1\45\1\46\1\47\1\50\1\uffff\1\52\1\53\3\uffff\1\64\1\66\1\67\5\uffff\1\3\1\44\21\uffff\1\56\1\40\1\57\1\51\1\54\1\65\30\uffff\1\33\7\uffff\1\63\5\uffff\1\27\6\uffff\1\6\11\uffff\1\34\1\uffff\1\43\3\uffff\1\60\4\uffff\1\62\11\uffff\1\36\1\5\1\55\15\uffff\1\61\4\uffff\1\10\1\20\27\uffff\1\4\1\uffff\1\7\2\uffff\1\41\1\uffff\1\25\11\uffff\1\11\2\uffff\1\16\1\uffff\1\17\4\uffff\1\2\1\uffff\1\23\1\uffff\1\13\7\uffff\1\42\1\37\1\uffff\1\22\1\uffff\1\1\5\uffff\1\21\3\uffff\1\26\1\35\1\uffff\1\24";
    static final String DFA25_specialS =
        "\36\uffff\1\13\43\uffff\1\3\32\uffff\1\15\1\14\1\12\1\10\32\uffff\1\24\1\6\1\0\1\uffff\1\16\1\11\1\4\1\5\26\uffff\1\20\1\25\1\23\1\26\1\uffff\1\7\1\2\1\1\22\uffff\1\22\1\21\1\17\77\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\30\1\41\1\34\1\37\1\uffff\1\27\1\36\1\17\1\20\2\uffff\1\21\1\35\1\31\13\uffff\1\25\1\10\1\32\1\3\1\33\2\uffff\32\42\5\uffff\1\40\1\2\1\42\1\11\1\14\1\7\1\42\1\16\1\42\1\1\1\5\3\42\1\23\1\22\1\4\1\15\1\42\1\6\2\42\1\24\4\42\1\12\1\26\1\13",
            "\1\44\1\43",
            "\1\45\3\uffff\1\47\1\46",
            "\1\50",
            "\1\53\12\uffff\1\54\14\uffff\1\52",
            "\1\55",
            "\1\57\7\uffff\1\56",
            "\1\60",
            "",
            "\1\62\2\uffff\1\61",
            "",
            "",
            "\1\64\11\uffff\1\63",
            "\1\65",
            "\1\66",
            "",
            "",
            "",
            "\1\67",
            "\1\70",
            "\1\72\3\uffff\1\71",
            "\1\73",
            "",
            "",
            "",
            "",
            "\1\75",
            "",
            "",
            "\1\100\20\uffff\1\77",
            "\47\41\1\101\uffd8\41",
            "\1\102",
            "",
            "",
            "",
            "\1\104\11\uffff\1\105\5\uffff\1\103",
            "\1\106",
            "\1\107\2\uffff\1\110",
            "\1\111",
            "\1\112",
            "",
            "",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\123\1\122",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\132",
            "\1\133",
            "\1\134",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\135",
            "\44\140\1\137\2\140\1\136\uffd8\140",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\171",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "\44\u0081\1\u0080\2\u0081\1\177\uffd8\u0081",
            "\173\u0082\1\u0083\uff84\u0082",
            "\44\140\1\137\2\140\1\136\uffd8\140",
            "",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "",
            "\1\u0098",
            "",
            "\44\u009b\1\u009a\2\u009b\1\u0099\uffd8\u009b",
            "\173\u009c\1\u009d\uff84\u009c",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "",
            "\44\u009f\1\u009e\2\u009f\1\uffff\uffd8\u009f",
            "\44\140\1\137\2\140\1\136\123\140\1\u00a0\uff84\140",
            "\44\140\1\137\2\140\1\136\uffd8\140",
            "\44\140\1\137\2\140\1\136\uffd8\140",
            "",
            "\1\u00a1",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "",
            "",
            "",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\44\u00b4\1\u00b3\2\u00b4\1\uffff\uffd8\u00b4",
            "\44\175\1\174\2\175\1\173\123\175\1\u00b5\uff84\175",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "",
            "\44\140\1\137\2\140\1\136\123\140\1\u00a0\uff84\140",
            "\44\140\1\137\2\140\1\136\uffd8\140",
            "\44\140\1\137\2\140\1\136\uffd8\140",
            "\1\u00b6",
            "",
            "",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00bc",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00be",
            "\1\u00bf",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\22\42\1\u00c1\7\42",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\44\175\1\174\2\175\1\173\123\175\1\u00b5\uff84\175",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\u00cd",
            "\1\u00ce",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\u00d0",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00d7",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\22\42\1\u00d9\7\42",
            "\1\u00db",
            "",
            "\1\u00dc",
            "",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "",
            "\1\u00e1",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00e4",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00e6",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00e8",
            "\1\u00e9",
            "",
            "",
            "\1\u00ea",
            "",
            "\1\u00eb",
            "",
            "\1\u00ec",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00f3",
            "",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | RULE_ISTRING_TEXT | RULE_ISTRING_LEFT | RULE_ISTRING_MIDDLE | RULE_ISTRING_RIGHT | RULE_SSTRING | RULE_SL_COMMENT | RULE_STRING | RULE_ID );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_125 = input.LA(1);

                        s = -1;
                        if ( (LA25_125=='\'') ) {s = 123;}

                        else if ( (LA25_125=='$') ) {s = 124;}

                        else if ( ((LA25_125>='\u0000' && LA25_125<='#')||(LA25_125>='%' && LA25_125<='&')||(LA25_125>='(' && LA25_125<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_160 = input.LA(1);

                        s = -1;
                        if ( (LA25_160=='\'') ) {s = 94;}

                        else if ( (LA25_160=='$') ) {s = 95;}

                        else if ( ((LA25_160>='\u0000' && LA25_160<='#')||(LA25_160>='%' && LA25_160<='&')||(LA25_160>='(' && LA25_160<='\uFFFF')) ) {s = 96;}

                        else s = 131;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_159 = input.LA(1);

                        s = -1;
                        if ( (LA25_159=='\'') ) {s = 94;}

                        else if ( (LA25_159=='$') ) {s = 95;}

                        else if ( ((LA25_159>='\u0000' && LA25_159<='#')||(LA25_159>='%' && LA25_159<='&')||(LA25_159>='(' && LA25_159<='\uFFFF')) ) {s = 96;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_66 = input.LA(1);

                        s = -1;
                        if ( (LA25_66=='\'') ) {s = 94;}

                        else if ( (LA25_66=='$') ) {s = 95;}

                        else if ( ((LA25_66>='\u0000' && LA25_66<='#')||(LA25_66>='%' && LA25_66<='&')||(LA25_66>='(' && LA25_66<='\uFFFF')) ) {s = 96;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_129 = input.LA(1);

                        s = -1;
                        if ( (LA25_129=='\'') ) {s = 94;}

                        else if ( (LA25_129=='$') ) {s = 95;}

                        else if ( ((LA25_129>='\u0000' && LA25_129<='#')||(LA25_129>='%' && LA25_129<='&')||(LA25_129>='(' && LA25_129<='\uFFFF')) ) {s = 96;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_130 = input.LA(1);

                        s = -1;
                        if ( (LA25_130=='\'') ) {s = 94;}

                        else if ( (LA25_130=='$') ) {s = 95;}

                        else if ( ((LA25_130>='\u0000' && LA25_130<='#')||(LA25_130>='%' && LA25_130<='&')||(LA25_130>='(' && LA25_130<='\uFFFF')) ) {s = 96;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_124 = input.LA(1);

                        s = -1;
                        if ( ((LA25_124>='\u0000' && LA25_124<='z')||(LA25_124>='|' && LA25_124<='\uFFFF')) ) {s = 156;}

                        else if ( (LA25_124=='{') ) {s = 157;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_158 = input.LA(1);

                        s = -1;
                        if ( (LA25_158=='{') ) {s = 160;}

                        else if ( (LA25_158=='\'') ) {s = 94;}

                        else if ( (LA25_158=='$') ) {s = 95;}

                        else if ( ((LA25_158>='\u0000' && LA25_158<='#')||(LA25_158>='%' && LA25_158<='&')||(LA25_158>='(' && LA25_158<='z')||(LA25_158>='|' && LA25_158<='\uFFFF')) ) {s = 96;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA25_96 = input.LA(1);

                        s = -1;
                        if ( (LA25_96=='\'') ) {s = 94;}

                        else if ( (LA25_96=='$') ) {s = 95;}

                        else if ( ((LA25_96>='\u0000' && LA25_96<='#')||(LA25_96>='%' && LA25_96<='&')||(LA25_96>='(' && LA25_96<='\uFFFF')) ) {s = 96;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA25_128 = input.LA(1);

                        s = -1;
                        if ( (LA25_128=='{') ) {s = 160;}

                        else if ( (LA25_128=='\'') ) {s = 94;}

                        else if ( (LA25_128=='$') ) {s = 95;}

                        else if ( ((LA25_128>='\u0000' && LA25_128<='#')||(LA25_128>='%' && LA25_128<='&')||(LA25_128>='(' && LA25_128<='z')||(LA25_128>='|' && LA25_128<='\uFFFF')) ) {s = 96;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA25_95 = input.LA(1);

                        s = -1;
                        if ( ((LA25_95>='\u0000' && LA25_95<='z')||(LA25_95>='|' && LA25_95<='\uFFFF')) ) {s = 130;}

                        else if ( (LA25_95=='{') ) {s = 131;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA25_30 = input.LA(1);

                        s = -1;
                        if ( (LA25_30=='\'') ) {s = 65;}

                        else if ( ((LA25_30>='\u0000' && LA25_30<='&')||(LA25_30>='(' && LA25_30<='\uFFFF')) ) {s = 33;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA25_94 = input.LA(1);

                        s = -1;
                        if ( (LA25_94=='\'') ) {s = 127;}

                        else if ( (LA25_94=='$') ) {s = 128;}

                        else if ( ((LA25_94>='\u0000' && LA25_94<='#')||(LA25_94>='%' && LA25_94<='&')||(LA25_94>='(' && LA25_94<='\uFFFF')) ) {s = 129;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA25_93 = input.LA(1);

                        s = -1;
                        if ( (LA25_93=='\'') ) {s = 123;}

                        else if ( (LA25_93=='$') ) {s = 124;}

                        else if ( ((LA25_93>='\u0000' && LA25_93<='#')||(LA25_93>='%' && LA25_93<='&')||(LA25_93>='(' && LA25_93<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA25_127 = input.LA(1);

                        s = -1;
                        if ( (LA25_127=='$') ) {s = 158;}

                        else if ( ((LA25_127>='\u0000' && LA25_127<='#')||(LA25_127>='%' && LA25_127<='&')||(LA25_127>='(' && LA25_127<='\uFFFF')) ) {s = 159;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA25_181 = input.LA(1);

                        s = -1;
                        if ( (LA25_181=='\'') ) {s = 123;}

                        else if ( (LA25_181=='$') ) {s = 124;}

                        else if ( ((LA25_181>='\u0000' && LA25_181<='#')||(LA25_181>='%' && LA25_181<='&')||(LA25_181>='(' && LA25_181<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA25_153 = input.LA(1);

                        s = -1;
                        if ( (LA25_153=='$') ) {s = 179;}

                        else if ( ((LA25_153>='\u0000' && LA25_153<='#')||(LA25_153>='%' && LA25_153<='&')||(LA25_153>='(' && LA25_153<='\uFFFF')) ) {s = 180;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA25_180 = input.LA(1);

                        s = -1;
                        if ( (LA25_180=='\'') ) {s = 123;}

                        else if ( (LA25_180=='$') ) {s = 124;}

                        else if ( ((LA25_180>='\u0000' && LA25_180<='#')||(LA25_180>='%' && LA25_180<='&')||(LA25_180>='(' && LA25_180<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA25_179 = input.LA(1);

                        s = -1;
                        if ( (LA25_179=='{') ) {s = 181;}

                        else if ( (LA25_179=='\'') ) {s = 123;}

                        else if ( (LA25_179=='$') ) {s = 124;}

                        else if ( ((LA25_179>='\u0000' && LA25_179<='#')||(LA25_179>='%' && LA25_179<='&')||(LA25_179>='(' && LA25_179<='z')||(LA25_179>='|' && LA25_179<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA25_155 = input.LA(1);

                        s = -1;
                        if ( (LA25_155=='\'') ) {s = 123;}

                        else if ( (LA25_155=='$') ) {s = 124;}

                        else if ( ((LA25_155>='\u0000' && LA25_155<='#')||(LA25_155>='%' && LA25_155<='&')||(LA25_155>='(' && LA25_155<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA25_123 = input.LA(1);

                        s = -1;
                        if ( (LA25_123=='\'') ) {s = 153;}

                        else if ( (LA25_123=='$') ) {s = 154;}

                        else if ( ((LA25_123>='\u0000' && LA25_123<='#')||(LA25_123>='%' && LA25_123<='&')||(LA25_123>='(' && LA25_123<='\uFFFF')) ) {s = 155;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA25_154 = input.LA(1);

                        s = -1;
                        if ( (LA25_154=='{') ) {s = 181;}

                        else if ( (LA25_154=='\'') ) {s = 123;}

                        else if ( (LA25_154=='$') ) {s = 124;}

                        else if ( ((LA25_154>='\u0000' && LA25_154<='#')||(LA25_154>='%' && LA25_154<='&')||(LA25_154>='(' && LA25_154<='z')||(LA25_154>='|' && LA25_154<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA25_156 = input.LA(1);

                        s = -1;
                        if ( (LA25_156=='\'') ) {s = 123;}

                        else if ( (LA25_156=='$') ) {s = 124;}

                        else if ( ((LA25_156>='\u0000' && LA25_156<='#')||(LA25_156>='%' && LA25_156<='&')||(LA25_156>='(' && LA25_156<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}