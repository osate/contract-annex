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
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
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
    public static final int RULE_WS=13;
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

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
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
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
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
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
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
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
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
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
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
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
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
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
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
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
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
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
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
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
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
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:41:7: ( 'claims' )
            // InternalContract.g:41:9: 'claims'
            {
            match("claims"); 


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
            // InternalContract.g:42:7: ( 'contracts' )
            // InternalContract.g:42:9: 'contracts'
            {
            match("contracts"); 


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
            // InternalContract.g:43:7: ( 'val' )
            // InternalContract.g:43:9: 'val'
            {
            match("val"); 


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
            // InternalContract.g:44:7: ( '=' )
            // InternalContract.g:44:9: '='
            {
            match('='); 

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
            // InternalContract.g:45:7: ( '||' )
            // InternalContract.g:45:9: '||'
            {
            match("||"); 


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
            // InternalContract.g:46:7: ( '&&' )
            // InternalContract.g:46:9: '&&'
            {
            match("&&"); 


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
            // InternalContract.g:47:7: ( '!' )
            // InternalContract.g:47:9: '!'
            {
            match('!'); 

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
            // InternalContract.g:48:7: ( '.' )
            // InternalContract.g:48:9: '.'
            {
            match('.'); 

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
            // InternalContract.g:49:7: ( '<' )
            // InternalContract.g:49:9: '<'
            {
            match('<'); 

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
            // InternalContract.g:50:7: ( '>' )
            // InternalContract.g:50:9: '>'
            {
            match('>'); 

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
            // InternalContract.g:51:7: ( '#' )
            // InternalContract.g:51:9: '#'
            {
            match('#'); 

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
            // InternalContract.g:52:7: ( '->' )
            // InternalContract.g:52:9: '->'
            {
            match("->"); 


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
            // InternalContract.g:53:7: ( 'self' )
            // InternalContract.g:53:9: 'self'
            {
            match("self"); 


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
            // InternalContract.g:54:7: ( '@' )
            // InternalContract.g:54:9: '@'
            {
            match('@'); 

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
            // InternalContract.g:55:7: ( '::' )
            // InternalContract.g:55:9: '::'
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
            // InternalContract.g:56:7: ( '<=>' )
            // InternalContract.g:56:9: '<=>'
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

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:57:7: ( ':' )
            // InternalContract.g:57:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "RULE_ISTRING_TEXT"
    public final void mRULE_ISTRING_TEXT() throws RecognitionException {
        try {
            int _type = RULE_ISTRING_TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:8554:19: ( '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // InternalContract.g:8554:21: '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match("'''"); 

            // InternalContract.g:8554:30: ( RULE_IN_ISTRING )*
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
            	    // InternalContract.g:8554:30: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalContract.g:8554:47: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
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
                    // InternalContract.g:8554:48: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // InternalContract.g:8554:57: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // InternalContract.g:8554:57: ( '\\'' ( '\\'' )? )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\'') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalContract.g:8554:58: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // InternalContract.g:8554:63: ( '\\'' )?
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( (LA2_0=='\'') ) {
                                alt2=1;
                            }
                            switch (alt2) {
                                case 1 :
                                    // InternalContract.g:8554:63: '\\''
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
            // InternalContract.g:8556:19: ( '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${' )
            // InternalContract.g:8556:21: '\\'\\'\\'' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${'
            {
            match("'''"); 

            // InternalContract.g:8556:30: ( RULE_IN_ISTRING )*
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
            	    // InternalContract.g:8556:30: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalContract.g:8556:47: ( '\\'' ( '\\'' )? )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\'') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalContract.g:8556:48: '\\'' ( '\\'' )?
                    {
                    match('\''); 
                    // InternalContract.g:8556:53: ( '\\'' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\'') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalContract.g:8556:53: '\\''
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
            // InternalContract.g:8558:21: ( '$}' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${' )
            // InternalContract.g:8558:23: '$}' ( RULE_IN_ISTRING )* ( '\\'' ( '\\'' )? )? '${'
            {
            match("$}"); 

            // InternalContract.g:8558:28: ( RULE_IN_ISTRING )*
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
            	    // InternalContract.g:8558:28: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalContract.g:8558:45: ( '\\'' ( '\\'' )? )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\'') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalContract.g:8558:46: '\\'' ( '\\'' )?
                    {
                    match('\''); 
                    // InternalContract.g:8558:51: ( '\\'' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\'') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalContract.g:8558:51: '\\''
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
            // InternalContract.g:8560:20: ( '$}' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF ) )
            // InternalContract.g:8560:22: '$}' ( RULE_IN_ISTRING )* ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
            {
            match("$}"); 

            // InternalContract.g:8560:27: ( RULE_IN_ISTRING )*
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
            	    // InternalContract.g:8560:27: RULE_IN_ISTRING
            	    {
            	    mRULE_IN_ISTRING(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalContract.g:8560:44: ( '\\'\\'\\'' | ( '\\'' ( '\\'' )? )? EOF )
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
                    // InternalContract.g:8560:45: '\\'\\'\\''
                    {
                    match("'''"); 


                    }
                    break;
                case 2 :
                    // InternalContract.g:8560:54: ( '\\'' ( '\\'' )? )? EOF
                    {
                    // InternalContract.g:8560:54: ( '\\'' ( '\\'' )? )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\'') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalContract.g:8560:55: '\\'' ( '\\'' )?
                            {
                            match('\''); 
                            // InternalContract.g:8560:60: ( '\\'' )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0=='\'') ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // InternalContract.g:8560:60: '\\''
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
            // InternalContract.g:8562:26: ( ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | '$' ~ ( '{' ) | ~ ( ( '\\'' | '$' ) ) ) )
            // InternalContract.g:8562:28: ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | '$' ~ ( '{' ) | ~ ( ( '\\'' | '$' ) ) )
            {
            // InternalContract.g:8562:28: ( '\\'\\'' ~ ( '\\'' ) | '\\'' ~ ( '\\'' ) | '$' ~ ( '{' ) | ~ ( ( '\\'' | '$' ) ) )
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
                    // InternalContract.g:8562:29: '\\'\\'' ~ ( '\\'' )
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
                    // InternalContract.g:8562:44: '\\'' ~ ( '\\'' )
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
                    // InternalContract.g:8562:57: '$' ~ ( '{' )
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
                    // InternalContract.g:8562:68: ~ ( ( '\\'' | '$' ) )
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
            // InternalContract.g:8564:14: ( '`' (~ ( '`' ) )* '`' )
            // InternalContract.g:8564:16: '`' (~ ( '`' ) )* '`'
            {
            match('`'); 
            // InternalContract.g:8564:20: (~ ( '`' ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='_')||(LA16_0>='a' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalContract.g:8564:20: ~ ( '`' )
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
            // InternalContract.g:8566:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalContract.g:8566:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // InternalContract.g:8566:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalContract.g:8566:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalContract.g:8566:40: ( ( '\\r' )? '\\n' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\n'||LA19_0=='\r') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalContract.g:8566:41: ( '\\r' )? '\\n'
                    {
                    // InternalContract.g:8566:41: ( '\\r' )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='\r') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalContract.g:8566:41: '\\r'
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
            // InternalContract.g:8568:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalContract.g:8568:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalContract.g:8568:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalContract.g:8568:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalContract.g:8568:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalContract.g:8568:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // InternalContract.g:8568:66: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalContract.g:8568:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalContract.g:8568:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalContract.g:8568:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // InternalContract.g:8568:137: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalContract.g:8570:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )* )
            // InternalContract.g:8570:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalContract.g:8570:31: ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='0' && LA24_0<='9')||(LA24_0>='A' && LA24_0<='Z')||LA24_0=='_'||(LA24_0>='a' && LA24_0<='z')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalContract.g:8570:32: ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
            	    {
            	    // InternalContract.g:8570:32: ( '_' )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0=='_') ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // InternalContract.g:8570:32: '_'
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalContract.g:8572:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalContract.g:8572:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalContract.g:8572:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='\t' && LA25_0<='\n')||LA25_0=='\r'||LA25_0==' ') ) {
                    alt25=1;
                }


                switch (alt25) {
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
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
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
        // InternalContract.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | RULE_ISTRING_TEXT | RULE_ISTRING_LEFT | RULE_ISTRING_MIDDLE | RULE_ISTRING_RIGHT | RULE_SSTRING | RULE_SL_COMMENT | RULE_STRING | RULE_ID | RULE_WS )
        int alt26=56;
        alt26 = dfa26.predict(input);
        switch (alt26) {
            case 1 :
                // InternalContract.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // InternalContract.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // InternalContract.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // InternalContract.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // InternalContract.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // InternalContract.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // InternalContract.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // InternalContract.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // InternalContract.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // InternalContract.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // InternalContract.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // InternalContract.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // InternalContract.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // InternalContract.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // InternalContract.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // InternalContract.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // InternalContract.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // InternalContract.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // InternalContract.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // InternalContract.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // InternalContract.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // InternalContract.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // InternalContract.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // InternalContract.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // InternalContract.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // InternalContract.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // InternalContract.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // InternalContract.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // InternalContract.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // InternalContract.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // InternalContract.g:1:190: T__44
                {
                mT__44(); 

                }
                break;
            case 32 :
                // InternalContract.g:1:196: T__45
                {
                mT__45(); 

                }
                break;
            case 33 :
                // InternalContract.g:1:202: T__46
                {
                mT__46(); 

                }
                break;
            case 34 :
                // InternalContract.g:1:208: T__47
                {
                mT__47(); 

                }
                break;
            case 35 :
                // InternalContract.g:1:214: T__48
                {
                mT__48(); 

                }
                break;
            case 36 :
                // InternalContract.g:1:220: T__49
                {
                mT__49(); 

                }
                break;
            case 37 :
                // InternalContract.g:1:226: T__50
                {
                mT__50(); 

                }
                break;
            case 38 :
                // InternalContract.g:1:232: T__51
                {
                mT__51(); 

                }
                break;
            case 39 :
                // InternalContract.g:1:238: T__52
                {
                mT__52(); 

                }
                break;
            case 40 :
                // InternalContract.g:1:244: T__53
                {
                mT__53(); 

                }
                break;
            case 41 :
                // InternalContract.g:1:250: T__54
                {
                mT__54(); 

                }
                break;
            case 42 :
                // InternalContract.g:1:256: T__55
                {
                mT__55(); 

                }
                break;
            case 43 :
                // InternalContract.g:1:262: T__56
                {
                mT__56(); 

                }
                break;
            case 44 :
                // InternalContract.g:1:268: T__57
                {
                mT__57(); 

                }
                break;
            case 45 :
                // InternalContract.g:1:274: T__58
                {
                mT__58(); 

                }
                break;
            case 46 :
                // InternalContract.g:1:280: T__59
                {
                mT__59(); 

                }
                break;
            case 47 :
                // InternalContract.g:1:286: T__60
                {
                mT__60(); 

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
            case 56 :
                // InternalContract.g:1:416: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA26_eotS =
        "\1\uffff\2\43\1\53\4\43\1\uffff\1\43\2\uffff\3\43\3\uffff\3\43\4\uffff\1\76\4\uffff\1\102\6\uffff\5\43\2\uffff\15\43\1\132\3\43\6\uffff\1\42\1\142\5\43\1\150\6\43\1\157\10\43\1\uffff\1\170\1\43\1\172\1\176\1\142\1\uffff\1\142\1\uffff\5\43\1\uffff\4\43\1\u008d\1\u008e\1\uffff\1\u008f\7\43\1\uffff\1\43\1\uffff\1\176\1\uffff\1\176\1\uffff\4\142\1\uffff\1\43\1\u00a1\1\u00a2\6\43\3\uffff\10\43\4\176\1\uffff\2\142\1\u0083\1\43\2\uffff\4\43\1\u00b9\1\43\1\u00bb\1\43\1\u00bd\1\u00bf\4\43\3\176\5\43\1\uffff\1\u00c9\1\uffff\1\43\1\uffff\1\u00cb\1\uffff\1\43\1\u00cd\4\43\1\u00d2\1\43\1\u00d4\1\uffff\1\u00d6\1\uffff\1\43\1\uffff\4\43\1\uffff\1\43\1\uffff\1\u00dd\1\uffff\1\43\1\u00df\1\43\1\u00e1\2\43\1\uffff\1\43\1\uffff\1\43\1\uffff\1\43\1\u00e7\3\43\1\uffff\1\u00eb\1\u00ec\1\43\2\uffff\1\u00ee\1\uffff";
    static final String DFA26_eofS =
        "\u00ef\uffff";
    static final String DFA26_minS =
        "\1\11\1\155\1\156\1\76\2\141\1\145\1\162\1\uffff\1\154\2\uffff\1\145\2\165\3\uffff\1\162\1\157\1\141\4\uffff\1\75\2\uffff\1\55\1\uffff\1\72\1\0\1\175\4\uffff\1\146\1\160\1\141\1\163\1\147\2\uffff\1\164\1\143\1\141\1\166\1\164\1\154\1\162\1\156\1\141\1\155\1\143\1\145\1\141\1\60\1\164\1\162\1\154\6\uffff\1\47\1\0\2\157\1\165\2\154\1\60\2\165\1\150\1\153\1\156\1\141\1\60\1\146\1\157\1\164\1\151\1\141\1\154\2\162\1\uffff\1\60\1\151\1\60\4\0\1\uffff\1\143\1\60\1\164\1\145\1\171\1\uffff\2\155\1\157\1\141\2\60\1\uffff\1\60\2\162\1\155\1\151\1\141\1\151\1\141\1\uffff\1\146\1\uffff\3\0\1\uffff\4\0\1\uffff\1\141\2\60\1\155\1\163\1\160\1\145\1\156\1\147\3\uffff\1\60\1\141\1\163\1\156\1\162\1\145\1\156\1\151\4\0\1\uffff\3\0\1\164\2\uffff\1\145\1\151\1\164\1\156\1\60\1\145\1\60\1\143\2\60\1\141\1\163\1\164\1\143\3\0\1\151\1\156\1\163\1\151\1\164\1\uffff\1\60\1\uffff\1\164\1\uffff\1\60\1\uffff\1\164\1\60\1\145\1\141\1\157\1\164\1\60\1\157\1\60\1\uffff\1\60\1\uffff\1\151\1\uffff\1\145\1\164\1\156\1\141\1\uffff\1\156\1\uffff\1\60\1\uffff\1\157\1\60\1\151\1\60\1\164\1\163\1\uffff\1\156\1\uffff\1\157\1\uffff\1\151\1\60\1\163\1\156\1\157\1\uffff\2\60\1\156\2\uffff\1\60\1\uffff";
    static final String DFA26_maxS =
        "\1\175\1\156\1\163\1\76\1\171\1\141\1\155\1\162\1\uffff\1\157\2\uffff\1\157\2\165\3\uffff\1\162\1\157\1\145\4\uffff\1\75\2\uffff\1\76\1\uffff\1\72\1\uffff\1\175\4\uffff\1\166\1\160\1\144\1\163\1\147\2\uffff\1\164\1\143\1\141\1\166\1\164\1\154\1\162\1\156\1\141\1\155\1\143\1\145\1\141\1\172\1\164\1\162\1\154\6\uffff\1\47\1\uffff\2\157\1\165\2\154\1\172\2\165\1\150\1\153\1\156\1\141\1\172\1\146\1\157\1\164\1\151\1\141\1\154\2\162\1\uffff\1\172\1\151\1\172\4\uffff\1\uffff\1\143\1\60\1\164\1\145\1\171\1\uffff\2\155\1\157\1\141\2\172\1\uffff\1\172\2\162\1\155\1\151\1\141\1\151\1\141\1\uffff\1\146\1\uffff\3\uffff\1\uffff\4\uffff\1\uffff\1\141\2\172\1\155\1\163\1\160\1\145\1\156\1\147\3\uffff\1\60\1\141\1\163\1\156\1\162\1\145\1\156\1\151\4\uffff\1\uffff\3\uffff\1\164\2\uffff\1\145\1\151\1\164\1\156\1\172\1\145\1\172\1\143\2\172\1\141\1\163\1\164\1\143\3\uffff\1\151\1\156\1\163\1\151\1\164\1\uffff\1\172\1\uffff\1\164\1\uffff\1\172\1\uffff\1\164\1\172\1\145\1\141\1\157\1\164\1\172\1\157\1\172\1\uffff\1\172\1\uffff\1\151\1\uffff\1\145\1\164\1\156\1\141\1\uffff\1\156\1\uffff\1\172\1\uffff\1\157\1\172\1\151\1\172\1\164\1\163\1\uffff\1\156\1\uffff\1\157\1\uffff\1\151\1\172\1\163\1\156\1\157\1\uffff\2\172\1\156\2\uffff\1\172\1\uffff";
    static final String DFA26_acceptS =
        "\10\uffff\1\12\1\uffff\1\14\1\15\3\uffff\1\30\1\31\1\32\3\uffff\1\43\1\44\1\45\1\46\1\uffff\1\50\1\51\1\uffff\1\54\3\uffff\1\64\1\66\1\67\1\70\5\uffff\1\3\1\42\21\uffff\1\56\1\47\1\52\1\65\1\55\1\57\27\uffff\1\33\7\uffff\1\63\5\uffff\1\27\6\uffff\1\6\10\uffff\1\34\1\uffff\1\41\3\uffff\1\60\4\uffff\1\62\11\uffff\1\36\1\5\1\53\14\uffff\1\61\4\uffff\1\10\1\20\26\uffff\1\4\1\uffff\1\7\1\uffff\1\37\1\uffff\1\25\11\uffff\1\11\1\uffff\1\16\1\uffff\1\17\4\uffff\1\2\1\uffff\1\23\1\uffff\1\13\6\uffff\1\40\1\uffff\1\22\1\uffff\1\1\5\uffff\1\21\3\uffff\1\26\1\35\1\uffff\1\24";
    static final String DFA26_specialS =
        "\37\uffff\1\5\44\uffff\1\21\31\uffff\1\0\1\3\1\4\1\25\31\uffff\1\17\1\1\1\13\1\uffff\1\14\1\26\1\22\1\23\25\uffff\1\16\1\11\1\10\1\12\1\uffff\1\24\1\20\1\15\21\uffff\1\7\1\6\1\2\73\uffff}>";
    static final String[] DFA26_transitionS = {
            "\2\44\2\uffff\1\44\22\uffff\1\44\1\27\1\42\1\33\1\40\1\uffff\1\26\1\37\1\17\1\20\2\uffff\1\21\1\34\1\30\13\uffff\1\36\1\10\1\31\1\3\1\32\1\uffff\1\35\32\43\5\uffff\1\41\1\2\1\43\1\11\1\14\1\7\1\43\1\16\1\43\1\1\1\5\3\43\1\23\1\22\1\4\1\15\1\43\1\6\2\43\1\24\4\43\1\12\1\25\1\13",
            "\1\46\1\45",
            "\1\47\3\uffff\1\51\1\50",
            "\1\52",
            "\1\55\12\uffff\1\56\14\uffff\1\54",
            "\1\57",
            "\1\61\7\uffff\1\60",
            "\1\62",
            "",
            "\1\64\2\uffff\1\63",
            "",
            "",
            "\1\66\11\uffff\1\65",
            "\1\67",
            "\1\70",
            "",
            "",
            "",
            "\1\71",
            "\1\72",
            "\1\74\3\uffff\1\73",
            "",
            "",
            "",
            "",
            "\1\75",
            "",
            "",
            "\1\100\20\uffff\1\77",
            "",
            "\1\101",
            "\47\42\1\103\uffd8\42",
            "\1\104",
            "",
            "",
            "",
            "",
            "\1\106\11\uffff\1\107\5\uffff\1\105",
            "\1\110",
            "\1\111\2\uffff\1\112",
            "\1\113",
            "\1\114",
            "",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\133",
            "\1\134",
            "\1\135",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\136",
            "\44\141\1\140\2\141\1\137\uffd8\141",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\171",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "\44\u0081\1\u0080\2\u0081\1\177\uffd8\u0081",
            "\173\u0082\1\u0083\uff84\u0082",
            "\44\141\1\140\2\141\1\137\uffd8\141",
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
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "",
            "\1\u0097",
            "",
            "\44\u009a\1\u0099\2\u009a\1\u0098\uffd8\u009a",
            "\173\u009b\1\u009c\uff84\u009b",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "",
            "\44\u009e\1\u009d\2\u009e\1\uffff\uffd8\u009e",
            "\44\141\1\140\2\141\1\137\123\141\1\u009f\uff84\141",
            "\44\141\1\140\2\141\1\137\uffd8\141",
            "\44\141\1\140\2\141\1\137\uffd8\141",
            "",
            "\1\u00a0",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "",
            "",
            "",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\44\u00b2\1\u00b1\2\u00b2\1\uffff\uffd8\u00b2",
            "\44\175\1\174\2\175\1\173\123\175\1\u00b3\uff84\175",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "",
            "\44\141\1\140\2\141\1\137\123\141\1\u009f\uff84\141",
            "\44\141\1\140\2\141\1\137\uffd8\141",
            "\44\141\1\140\2\141\1\137\uffd8\141",
            "\1\u00b4",
            "",
            "",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00ba",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00bc",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\22\43\1\u00be\7\43",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\44\175\1\174\2\175\1\173\123\175\1\u00b3\uff84\175",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "\44\175\1\174\2\175\1\173\uffd8\175",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\u00ca",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\u00cc",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00d3",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\22\43\1\u00d5\7\43",
            "",
            "\1\u00d7",
            "",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "",
            "\1\u00dc",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\u00de",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00e0",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00e2",
            "\1\u00e3",
            "",
            "\1\u00e4",
            "",
            "\1\u00e5",
            "",
            "\1\u00e6",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00ed",
            "",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | RULE_ISTRING_TEXT | RULE_ISTRING_LEFT | RULE_ISTRING_MIDDLE | RULE_ISTRING_RIGHT | RULE_SSTRING | RULE_SL_COMMENT | RULE_STRING | RULE_ID | RULE_WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_94 = input.LA(1);

                        s = -1;
                        if ( (LA26_94=='\'') ) {s = 123;}

                        else if ( (LA26_94=='$') ) {s = 124;}

                        else if ( ((LA26_94>='\u0000' && LA26_94<='#')||(LA26_94>='%' && LA26_94<='&')||(LA26_94>='(' && LA26_94<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_124 = input.LA(1);

                        s = -1;
                        if ( ((LA26_124>='\u0000' && LA26_124<='z')||(LA26_124>='|' && LA26_124<='\uFFFF')) ) {s = 155;}

                        else if ( (LA26_124=='{') ) {s = 156;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_179 = input.LA(1);

                        s = -1;
                        if ( (LA26_179=='\'') ) {s = 123;}

                        else if ( (LA26_179=='$') ) {s = 124;}

                        else if ( ((LA26_179>='\u0000' && LA26_179<='#')||(LA26_179>='%' && LA26_179<='&')||(LA26_179>='(' && LA26_179<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA26_95 = input.LA(1);

                        s = -1;
                        if ( (LA26_95=='\'') ) {s = 127;}

                        else if ( (LA26_95=='$') ) {s = 128;}

                        else if ( ((LA26_95>='\u0000' && LA26_95<='#')||(LA26_95>='%' && LA26_95<='&')||(LA26_95>='(' && LA26_95<='\uFFFF')) ) {s = 129;}

                        else s = 98;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA26_96 = input.LA(1);

                        s = -1;
                        if ( ((LA26_96>='\u0000' && LA26_96<='z')||(LA26_96>='|' && LA26_96<='\uFFFF')) ) {s = 130;}

                        else if ( (LA26_96=='{') ) {s = 131;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA26_31 = input.LA(1);

                        s = -1;
                        if ( (LA26_31=='\'') ) {s = 67;}

                        else if ( ((LA26_31>='\u0000' && LA26_31<='&')||(LA26_31>='(' && LA26_31<='\uFFFF')) ) {s = 34;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA26_178 = input.LA(1);

                        s = -1;
                        if ( (LA26_178=='\'') ) {s = 123;}

                        else if ( (LA26_178=='$') ) {s = 124;}

                        else if ( ((LA26_178>='\u0000' && LA26_178<='#')||(LA26_178>='%' && LA26_178<='&')||(LA26_178>='(' && LA26_178<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA26_177 = input.LA(1);

                        s = -1;
                        if ( (LA26_177=='{') ) {s = 179;}

                        else if ( (LA26_177=='\'') ) {s = 123;}

                        else if ( (LA26_177=='$') ) {s = 124;}

                        else if ( ((LA26_177>='\u0000' && LA26_177<='#')||(LA26_177>='%' && LA26_177<='&')||(LA26_177>='(' && LA26_177<='z')||(LA26_177>='|' && LA26_177<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA26_154 = input.LA(1);

                        s = -1;
                        if ( (LA26_154=='\'') ) {s = 123;}

                        else if ( (LA26_154=='$') ) {s = 124;}

                        else if ( ((LA26_154>='\u0000' && LA26_154<='#')||(LA26_154>='%' && LA26_154<='&')||(LA26_154>='(' && LA26_154<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA26_153 = input.LA(1);

                        s = -1;
                        if ( (LA26_153=='{') ) {s = 179;}

                        else if ( (LA26_153=='\'') ) {s = 123;}

                        else if ( (LA26_153=='$') ) {s = 124;}

                        else if ( ((LA26_153>='\u0000' && LA26_153<='#')||(LA26_153>='%' && LA26_153<='&')||(LA26_153>='(' && LA26_153<='z')||(LA26_153>='|' && LA26_153<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA26_155 = input.LA(1);

                        s = -1;
                        if ( (LA26_155=='\'') ) {s = 123;}

                        else if ( (LA26_155=='$') ) {s = 124;}

                        else if ( ((LA26_155>='\u0000' && LA26_155<='#')||(LA26_155>='%' && LA26_155<='&')||(LA26_155>='(' && LA26_155<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA26_125 = input.LA(1);

                        s = -1;
                        if ( (LA26_125=='\'') ) {s = 123;}

                        else if ( (LA26_125=='$') ) {s = 124;}

                        else if ( ((LA26_125>='\u0000' && LA26_125<='#')||(LA26_125>='%' && LA26_125<='&')||(LA26_125>='(' && LA26_125<='\uFFFF')) ) {s = 125;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA26_127 = input.LA(1);

                        s = -1;
                        if ( (LA26_127=='$') ) {s = 157;}

                        else if ( ((LA26_127>='\u0000' && LA26_127<='#')||(LA26_127>='%' && LA26_127<='&')||(LA26_127>='(' && LA26_127<='\uFFFF')) ) {s = 158;}

                        else s = 98;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA26_159 = input.LA(1);

                        s = -1;
                        if ( (LA26_159=='\'') ) {s = 95;}

                        else if ( (LA26_159=='$') ) {s = 96;}

                        else if ( ((LA26_159>='\u0000' && LA26_159<='#')||(LA26_159>='%' && LA26_159<='&')||(LA26_159>='(' && LA26_159<='\uFFFF')) ) {s = 97;}

                        else s = 131;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA26_152 = input.LA(1);

                        s = -1;
                        if ( (LA26_152=='$') ) {s = 177;}

                        else if ( ((LA26_152>='\u0000' && LA26_152<='#')||(LA26_152>='%' && LA26_152<='&')||(LA26_152>='(' && LA26_152<='\uFFFF')) ) {s = 178;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA26_123 = input.LA(1);

                        s = -1;
                        if ( (LA26_123=='\'') ) {s = 152;}

                        else if ( (LA26_123=='$') ) {s = 153;}

                        else if ( ((LA26_123>='\u0000' && LA26_123<='#')||(LA26_123>='%' && LA26_123<='&')||(LA26_123>='(' && LA26_123<='\uFFFF')) ) {s = 154;}

                        else s = 126;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA26_158 = input.LA(1);

                        s = -1;
                        if ( (LA26_158=='\'') ) {s = 95;}

                        else if ( (LA26_158=='$') ) {s = 96;}

                        else if ( ((LA26_158>='\u0000' && LA26_158<='#')||(LA26_158>='%' && LA26_158<='&')||(LA26_158>='(' && LA26_158<='\uFFFF')) ) {s = 97;}

                        else s = 98;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA26_68 = input.LA(1);

                        s = -1;
                        if ( (LA26_68=='\'') ) {s = 95;}

                        else if ( (LA26_68=='$') ) {s = 96;}

                        else if ( ((LA26_68>='\u0000' && LA26_68<='#')||(LA26_68>='%' && LA26_68<='&')||(LA26_68>='(' && LA26_68<='\uFFFF')) ) {s = 97;}

                        else s = 98;

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA26_129 = input.LA(1);

                        s = -1;
                        if ( (LA26_129=='\'') ) {s = 95;}

                        else if ( (LA26_129=='$') ) {s = 96;}

                        else if ( ((LA26_129>='\u0000' && LA26_129<='#')||(LA26_129>='%' && LA26_129<='&')||(LA26_129>='(' && LA26_129<='\uFFFF')) ) {s = 97;}

                        else s = 98;

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA26_130 = input.LA(1);

                        s = -1;
                        if ( (LA26_130=='\'') ) {s = 95;}

                        else if ( (LA26_130=='$') ) {s = 96;}

                        else if ( ((LA26_130>='\u0000' && LA26_130<='#')||(LA26_130>='%' && LA26_130<='&')||(LA26_130>='(' && LA26_130<='\uFFFF')) ) {s = 97;}

                        else s = 98;

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA26_157 = input.LA(1);

                        s = -1;
                        if ( (LA26_157=='{') ) {s = 159;}

                        else if ( (LA26_157=='\'') ) {s = 95;}

                        else if ( (LA26_157=='$') ) {s = 96;}

                        else if ( ((LA26_157>='\u0000' && LA26_157<='#')||(LA26_157>='%' && LA26_157<='&')||(LA26_157>='(' && LA26_157<='z')||(LA26_157>='|' && LA26_157<='\uFFFF')) ) {s = 97;}

                        else s = 98;

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA26_97 = input.LA(1);

                        s = -1;
                        if ( (LA26_97=='\'') ) {s = 95;}

                        else if ( (LA26_97=='$') ) {s = 96;}

                        else if ( ((LA26_97>='\u0000' && LA26_97<='#')||(LA26_97>='%' && LA26_97<='&')||(LA26_97>='(' && LA26_97<='\uFFFF')) ) {s = 97;}

                        else s = 98;

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA26_128 = input.LA(1);

                        s = -1;
                        if ( (LA26_128=='{') ) {s = 159;}

                        else if ( (LA26_128=='\'') ) {s = 95;}

                        else if ( (LA26_128=='$') ) {s = 96;}

                        else if ( ((LA26_128>='\u0000' && LA26_128<='#')||(LA26_128>='%' && LA26_128<='&')||(LA26_128>='(' && LA26_128<='z')||(LA26_128>='|' && LA26_128<='\uFFFF')) ) {s = 97;}

                        else s = 98;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}