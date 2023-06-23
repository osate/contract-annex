package org.osate.contract.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.contract.services.ContractGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Assurance Contract Annex Plugin for OSATE
 * Copyright 2023 Carnegie Mellon University.
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE 
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO 
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT 
 * NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR 
 * RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE 
 * ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * Released under a BSD (SEI)-style license, please see license.txt or contact 
 * permission@sei.cmu.edu for full terms.
 * [DISTRIBUTION STATEMENT A] This material has been approved for public release and 
 * unlimited distribution.  Please see Copyright notice for non-US Government use and 
 * distribution.
 * Carnegie Mellon® is registered in the U.S. Patent and Trademark Office by Carnegie 
 * Mellon University.
 * This Software includes and/or makes use of the following Third-Party Software subject 
 * to its own license:
 * 1. Z3 (https://github.com/Z3Prover/z3/blob/master/LICENSE.txt) Copyright Microsoft 
 * Corporation.
 * 2. Eclipse (https://www.eclipse.org/legal/epl-2.0/) Copyright 2000, 2023 Eclipse 
 * contributors and others.
 * DM23-0575
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalContractParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SSTRING", "RULE_ISTRING_TEXT", "RULE_ISTRING_LEFT", "RULE_ISTRING_MIDDLE", "RULE_ISTRING_RIGHT", "RULE_STRING", "RULE_INTEGER_LIT", "RULE_REAL_LIT", "RULE_IN_ISTRING", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_BASED_INTEGER", "RULE_EXTENDED_DIGIT", "RULE_WS", "'contract'", "'{'", "'domains'", "'queries'", "'input'", "'assumptions'", "'guarantee'", "';'", "'invocation'", "'analysis'", "'}'", "'=>'", "'<=>'", "'argument'", "'implementation'", "'domain'", "'declarations'", "'or'", "'('", "')'", "'verification'", "'plan'", "'component'", "':'", "'claims'", "'contracts'", "'val'", "','", "'='", "'||'", "'&&'", "'!'", "'.'", "'#'", "'->'", "'self'", "'root'", "'use'", "'verify'", "'::'", "'+=>'", "'constant'", "'true'", "'false'", "'reference'", "'['", "']'", "'compute'", "'classifier'", "'+'", "'-'", "'..'", "'delta'", "'applies'", "'to'", "'in'", "'binding'", "'modes'", "'*'", "'python'", "'java'", "'smt'"
    };
    public static final int T__50=50;
    public static final int RULE_ISTRING_TEXT=6;
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
    public static final int RULE_ISTRING_RIGHT=9;
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
    public static final int RULE_STRING=10;
    public static final int RULE_SL_COMMENT=14;
    public static final int RULE_SSTRING=5;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_ISTRING_MIDDLE=8;
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
    public static final int RULE_WS=20;
    public static final int RULE_EXPONENT=16;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int RULE_ISTRING_LEFT=7;
    public static final int RULE_EXTENDED_DIGIT=19;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalContractParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContractParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContractParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContract.g"; }



     	private ContractGrammarAccess grammarAccess;

        public InternalContractParser(TokenStream input, ContractGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "AnnexLibrary";
       	}

       	@Override
       	protected ContractGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleAnnexLibrary"
    // InternalContract.g:88:1: entryRuleAnnexLibrary returns [EObject current=null] : iv_ruleAnnexLibrary= ruleAnnexLibrary EOF ;
    public final EObject entryRuleAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnexLibrary = null;


        try {
            // InternalContract.g:88:53: (iv_ruleAnnexLibrary= ruleAnnexLibrary EOF )
            // InternalContract.g:89:2: iv_ruleAnnexLibrary= ruleAnnexLibrary EOF
            {
             newCompositeNode(grammarAccess.getAnnexLibraryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnexLibrary=ruleAnnexLibrary();

            state._fsp--;

             current =iv_ruleAnnexLibrary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnexLibrary"


    // $ANTLR start "ruleAnnexLibrary"
    // InternalContract.g:95:1: ruleAnnexLibrary returns [EObject current=null] : this_ContractLibrary_0= ruleContractLibrary ;
    public final EObject ruleAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject this_ContractLibrary_0 = null;



        	enterRule();

        try {
            // InternalContract.g:101:2: (this_ContractLibrary_0= ruleContractLibrary )
            // InternalContract.g:102:2: this_ContractLibrary_0= ruleContractLibrary
            {

            		newCompositeNode(grammarAccess.getAnnexLibraryAccess().getContractLibraryParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_ContractLibrary_0=ruleContractLibrary();

            state._fsp--;


            		current = this_ContractLibrary_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnexLibrary"


    // $ANTLR start "entryRuleContractLibrary"
    // InternalContract.g:113:1: entryRuleContractLibrary returns [EObject current=null] : iv_ruleContractLibrary= ruleContractLibrary EOF ;
    public final EObject entryRuleContractLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractLibrary = null;


        try {
            // InternalContract.g:113:56: (iv_ruleContractLibrary= ruleContractLibrary EOF )
            // InternalContract.g:114:2: iv_ruleContractLibrary= ruleContractLibrary EOF
            {
             newCompositeNode(grammarAccess.getContractLibraryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractLibrary=ruleContractLibrary();

            state._fsp--;

             current =iv_ruleContractLibrary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractLibrary"


    // $ANTLR start "ruleContractLibrary"
    // InternalContract.g:120:1: ruleContractLibrary returns [EObject current=null] : ( () ( (lv_contractElements_1_0= ruleContractElement ) )* ) ;
    public final EObject ruleContractLibrary() throws RecognitionException {
        EObject current = null;

        EObject lv_contractElements_1_0 = null;



        	enterRule();

        try {
            // InternalContract.g:126:2: ( ( () ( (lv_contractElements_1_0= ruleContractElement ) )* ) )
            // InternalContract.g:127:2: ( () ( (lv_contractElements_1_0= ruleContractElement ) )* )
            {
            // InternalContract.g:127:2: ( () ( (lv_contractElements_1_0= ruleContractElement ) )* )
            // InternalContract.g:128:3: () ( (lv_contractElements_1_0= ruleContractElement ) )*
            {
            // InternalContract.g:128:3: ()
            // InternalContract.g:129:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContractLibraryAccess().getContractLibraryAction_0(),
            					current);
            			

            }

            // InternalContract.g:135:3: ( (lv_contractElements_1_0= ruleContractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==21||LA1_0==34||LA1_0==36||LA1_0==41) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContract.g:136:4: (lv_contractElements_1_0= ruleContractElement )
            	    {
            	    // InternalContract.g:136:4: (lv_contractElements_1_0= ruleContractElement )
            	    // InternalContract.g:137:5: lv_contractElements_1_0= ruleContractElement
            	    {

            	    					newCompositeNode(grammarAccess.getContractLibraryAccess().getContractElementsContractElementParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_contractElements_1_0=ruleContractElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContractLibraryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"contractElements",
            	    						lv_contractElements_1_0,
            	    						"org.osate.contract.Contract.ContractElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractLibrary"


    // $ANTLR start "entryRuleContractElement"
    // InternalContract.g:158:1: entryRuleContractElement returns [EObject current=null] : iv_ruleContractElement= ruleContractElement EOF ;
    public final EObject entryRuleContractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractElement = null;


        try {
            // InternalContract.g:158:56: (iv_ruleContractElement= ruleContractElement EOF )
            // InternalContract.g:159:2: iv_ruleContractElement= ruleContractElement EOF
            {
             newCompositeNode(grammarAccess.getContractElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractElement=ruleContractElement();

            state._fsp--;

             current =iv_ruleContractElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractElement"


    // $ANTLR start "ruleContractElement"
    // InternalContract.g:165:1: ruleContractElement returns [EObject current=null] : (this_Implementation_0= ruleImplementation | this_Domain_1= ruleDomain | this_Argument_2= ruleArgument | this_Contract_3= ruleContract | this_VerificationPlan_4= ruleVerificationPlan ) ;
    public final EObject ruleContractElement() throws RecognitionException {
        EObject current = null;

        EObject this_Implementation_0 = null;

        EObject this_Domain_1 = null;

        EObject this_Argument_2 = null;

        EObject this_Contract_3 = null;

        EObject this_VerificationPlan_4 = null;



        	enterRule();

        try {
            // InternalContract.g:171:2: ( (this_Implementation_0= ruleImplementation | this_Domain_1= ruleDomain | this_Argument_2= ruleArgument | this_Contract_3= ruleContract | this_VerificationPlan_4= ruleVerificationPlan ) )
            // InternalContract.g:172:2: (this_Implementation_0= ruleImplementation | this_Domain_1= ruleDomain | this_Argument_2= ruleArgument | this_Contract_3= ruleContract | this_VerificationPlan_4= ruleVerificationPlan )
            {
            // InternalContract.g:172:2: (this_Implementation_0= ruleImplementation | this_Domain_1= ruleDomain | this_Argument_2= ruleArgument | this_Contract_3= ruleContract | this_VerificationPlan_4= ruleVerificationPlan )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 21:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_ID) ) {
                    alt2=4;
                }
                else if ( (LA2_1==35) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                alt2=2;
                }
                break;
            case 34:
                {
                alt2=3;
                }
                break;
            case 41:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalContract.g:173:3: this_Implementation_0= ruleImplementation
                    {

                    			newCompositeNode(grammarAccess.getContractElementAccess().getImplementationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Implementation_0=ruleImplementation();

                    state._fsp--;


                    			current = this_Implementation_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalContract.g:182:3: this_Domain_1= ruleDomain
                    {

                    			newCompositeNode(grammarAccess.getContractElementAccess().getDomainParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Domain_1=ruleDomain();

                    state._fsp--;


                    			current = this_Domain_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalContract.g:191:3: this_Argument_2= ruleArgument
                    {

                    			newCompositeNode(grammarAccess.getContractElementAccess().getArgumentParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Argument_2=ruleArgument();

                    state._fsp--;


                    			current = this_Argument_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalContract.g:200:3: this_Contract_3= ruleContract
                    {

                    			newCompositeNode(grammarAccess.getContractElementAccess().getContractParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Contract_3=ruleContract();

                    state._fsp--;


                    			current = this_Contract_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalContract.g:209:3: this_VerificationPlan_4= ruleVerificationPlan
                    {

                    			newCompositeNode(grammarAccess.getContractElementAccess().getVerificationPlanParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_VerificationPlan_4=ruleVerificationPlan();

                    state._fsp--;


                    			current = this_VerificationPlan_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractElement"


    // $ANTLR start "entryRuleContract"
    // InternalContract.g:221:1: entryRuleContract returns [EObject current=null] : iv_ruleContract= ruleContract EOF ;
    public final EObject entryRuleContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContract = null;


        try {
            // InternalContract.g:221:49: (iv_ruleContract= ruleContract EOF )
            // InternalContract.g:222:2: iv_ruleContract= ruleContract EOF
            {
             newCompositeNode(grammarAccess.getContractRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContract=ruleContract();

            state._fsp--;

             current =iv_ruleContract; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContract"


    // $ANTLR start "ruleContract"
    // InternalContract.g:228:1: ruleContract returns [EObject current=null] : (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )? (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )? (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )? (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )? ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )? otherlv_19= '}' ) ;
    public final EObject ruleContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject this_Domains_4 = null;

        EObject this_Queries_6 = null;

        EObject lv_inputs_9_0 = null;

        EObject this_Assumptions_11 = null;

        EObject this_Exact_13 = null;

        EObject lv_guarantee_14_0 = null;

        EObject this_Analyses_18 = null;



        	enterRule();

        try {
            // InternalContract.g:234:2: ( (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )? (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )? (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )? (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )? ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )? otherlv_19= '}' ) )
            // InternalContract.g:235:2: (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )? (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )? (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )? (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )? ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )? otherlv_19= '}' )
            {
            // InternalContract.g:235:2: (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )? (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )? (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )? (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )? ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )? otherlv_19= '}' )
            // InternalContract.g:236:3: otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )? (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )? (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )? (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )? ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )? otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getContractAccess().getContractKeyword_0());
            		
            // InternalContract.g:240:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:241:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:241:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:242:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContractAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContractRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.osate.xtext.aadl2.properties.Properties.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getContractAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalContract.g:262:3: (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==23) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalContract.g:263:4: otherlv_3= 'domains' this_Domains_4= ruleDomains[$current]
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getContractAccess().getDomainsKeyword_3_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getContractRule());
                    				}
                    				newCompositeNode(grammarAccess.getContractAccess().getDomainsParserRuleCall_3_1());
                    			
                    pushFollow(FOLLOW_8);
                    this_Domains_4=ruleDomains(current);

                    state._fsp--;


                    				current = this_Domains_4;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:279:3: (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==24) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalContract.g:280:4: otherlv_5= 'queries' this_Queries_6= ruleQueries[$current]
                    {
                    otherlv_5=(Token)match(input,24,FOLLOW_9); 

                    				newLeafNode(otherlv_5, grammarAccess.getContractAccess().getQueriesKeyword_4_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getContractRule());
                    				}
                    				newCompositeNode(grammarAccess.getContractAccess().getQueriesParserRuleCall_4_1());
                    			
                    pushFollow(FOLLOW_10);
                    this_Queries_6=ruleQueries(current);

                    state._fsp--;


                    				current = this_Queries_6;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:296:3: (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalContract.g:297:4: otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )*
                    {
                    otherlv_7=(Token)match(input,25,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getContractAccess().getInputKeyword_5_0());
                    			
                    otherlv_8=(Token)match(input,26,FOLLOW_12); 

                    				newLeafNode(otherlv_8, grammarAccess.getContractAccess().getAssumptionsKeyword_5_1());
                    			
                    // InternalContract.g:305:4: ( (lv_inputs_9_0= ruleInputAssumption ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=RULE_SSTRING && LA5_0<=RULE_ISTRING_LEFT)||LA5_0==28||(LA5_0>=80 && LA5_0<=82)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalContract.g:306:5: (lv_inputs_9_0= ruleInputAssumption )
                    	    {
                    	    // InternalContract.g:306:5: (lv_inputs_9_0= ruleInputAssumption )
                    	    // InternalContract.g:307:6: lv_inputs_9_0= ruleInputAssumption
                    	    {

                    	    						newCompositeNode(grammarAccess.getContractAccess().getInputsInputAssumptionParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_12);
                    	    lv_inputs_9_0=ruleInputAssumption();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getContractRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"inputs",
                    	    							lv_inputs_9_0,
                    	    							"org.osate.contract.Contract.InputAssumption");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalContract.g:325:3: (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==26) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalContract.g:326:4: otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current]
                    {
                    otherlv_10=(Token)match(input,26,FOLLOW_13); 

                    				newLeafNode(otherlv_10, grammarAccess.getContractAccess().getAssumptionsKeyword_6_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getContractRule());
                    				}
                    				newCompositeNode(grammarAccess.getContractAccess().getAssumptionsParserRuleCall_6_1());
                    			
                    pushFollow(FOLLOW_14);
                    this_Assumptions_11=ruleAssumptions(current);

                    state._fsp--;


                    				current = this_Assumptions_11;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:342:3: (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalContract.g:343:4: otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';'
                    {
                    otherlv_12=(Token)match(input,27,FOLLOW_15); 

                    				newLeafNode(otherlv_12, grammarAccess.getContractAccess().getGuaranteeKeyword_7_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getContractRule());
                    				}
                    				newCompositeNode(grammarAccess.getContractAccess().getExactParserRuleCall_7_1());
                    			
                    pushFollow(FOLLOW_16);
                    this_Exact_13=ruleExact(current);

                    state._fsp--;


                    				current = this_Exact_13;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalContract.g:358:4: ( (lv_guarantee_14_0= ruleGuarantee ) )
                    // InternalContract.g:359:5: (lv_guarantee_14_0= ruleGuarantee )
                    {
                    // InternalContract.g:359:5: (lv_guarantee_14_0= ruleGuarantee )
                    // InternalContract.g:360:6: lv_guarantee_14_0= ruleGuarantee
                    {

                    						newCompositeNode(grammarAccess.getContractAccess().getGuaranteeGuaranteeParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_guarantee_14_0=ruleGuarantee();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContractRule());
                    						}
                    						set(
                    							current,
                    							"guarantee",
                    							lv_guarantee_14_0,
                    							"org.osate.contract.Contract.Guarantee");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_15, grammarAccess.getContractAccess().getSemicolonKeyword_7_3());
                    			

                    }
                    break;

            }

            // InternalContract.g:382:3: ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=29 && LA10_0<=30)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalContract.g:383:4: (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current]
                    {
                    // InternalContract.g:383:4: (otherlv_16= 'invocation' | otherlv_17= 'analysis' )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==29) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==30) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalContract.g:384:5: otherlv_16= 'invocation'
                            {
                            otherlv_16=(Token)match(input,29,FOLLOW_19); 

                            					newLeafNode(otherlv_16, grammarAccess.getContractAccess().getInvocationKeyword_8_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalContract.g:389:5: otherlv_17= 'analysis'
                            {
                            otherlv_17=(Token)match(input,30,FOLLOW_19); 

                            					newLeafNode(otherlv_17, grammarAccess.getContractAccess().getAnalysisKeyword_8_0_1());
                            				

                            }
                            break;

                    }


                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getContractRule());
                    				}
                    				newCompositeNode(grammarAccess.getContractAccess().getAnalysesParserRuleCall_8_1());
                    			
                    pushFollow(FOLLOW_20);
                    this_Analyses_18=ruleAnalyses(current);

                    state._fsp--;


                    				current = this_Analyses_18;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            otherlv_19=(Token)match(input,31,FOLLOW_2); 

            			newLeafNode(otherlv_19, grammarAccess.getContractAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContract"


    // $ANTLR start "ruleExact"
    // InternalContract.g:415:1: ruleExact[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '=>' | ( (lv_exact_1_0= '<=>' ) ) ) ;
    public final EObject ruleExact(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token lv_exact_1_0=null;


        	enterRule();

        try {
            // InternalContract.g:421:2: ( (otherlv_0= '=>' | ( (lv_exact_1_0= '<=>' ) ) ) )
            // InternalContract.g:422:2: (otherlv_0= '=>' | ( (lv_exact_1_0= '<=>' ) ) )
            {
            // InternalContract.g:422:2: (otherlv_0= '=>' | ( (lv_exact_1_0= '<=>' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==32) ) {
                alt11=1;
            }
            else if ( (LA11_0==33) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalContract.g:423:3: otherlv_0= '=>'
                    {
                    otherlv_0=(Token)match(input,32,FOLLOW_2); 

                    			newLeafNode(otherlv_0, grammarAccess.getExactAccess().getEqualsSignGreaterThanSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalContract.g:428:3: ( (lv_exact_1_0= '<=>' ) )
                    {
                    // InternalContract.g:428:3: ( (lv_exact_1_0= '<=>' ) )
                    // InternalContract.g:429:4: (lv_exact_1_0= '<=>' )
                    {
                    // InternalContract.g:429:4: (lv_exact_1_0= '<=>' )
                    // InternalContract.g:430:5: lv_exact_1_0= '<=>'
                    {
                    lv_exact_1_0=(Token)match(input,33,FOLLOW_2); 

                    					newLeafNode(lv_exact_1_0, grammarAccess.getExactAccess().getExactLessThanSignEqualsSignGreaterThanSignKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getExactRule());
                    					}
                    					setWithLastConsumed(current, "exact", lv_exact_1_0 != null, "<=>");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExact"


    // $ANTLR start "ruleQueries"
    // InternalContract.g:447:1: ruleQueries[EObject in_current] returns [EObject current=in_current] : ( ( (lv_queries_0_0= ruleQuery ) )? otherlv_1= ';' )* ;
    public final EObject ruleQueries(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_queries_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:453:2: ( ( ( (lv_queries_0_0= ruleQuery ) )? otherlv_1= ';' )* )
            // InternalContract.g:454:2: ( ( (lv_queries_0_0= ruleQuery ) )? otherlv_1= ';' )*
            {
            // InternalContract.g:454:2: ( ( (lv_queries_0_0= ruleQuery ) )? otherlv_1= ';' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28||LA13_0==47) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalContract.g:455:3: ( (lv_queries_0_0= ruleQuery ) )? otherlv_1= ';'
            	    {
            	    // InternalContract.g:455:3: ( (lv_queries_0_0= ruleQuery ) )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==47) ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // InternalContract.g:456:4: (lv_queries_0_0= ruleQuery )
            	            {
            	            // InternalContract.g:456:4: (lv_queries_0_0= ruleQuery )
            	            // InternalContract.g:457:5: lv_queries_0_0= ruleQuery
            	            {

            	            					newCompositeNode(grammarAccess.getQueriesAccess().getQueriesQueryParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_17);
            	            lv_queries_0_0=ruleQuery();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getQueriesRule());
            	            					}
            	            					add(
            	            						current,
            	            						"queries",
            	            						lv_queries_0_0,
            	            						"org.osate.contract.Contract.Query");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_1=(Token)match(input,28,FOLLOW_21); 

            	    			newLeafNode(otherlv_1, grammarAccess.getQueriesAccess().getSemicolonKeyword_1());
            	    		

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueries"


    // $ANTLR start "ruleDomains"
    // InternalContract.g:483:1: ruleDomains[EObject in_current] returns [EObject current=in_current] : ( ( ( ruleQPREF ) )? otherlv_1= ';' )* ;
    public final EObject ruleDomains(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalContract.g:489:2: ( ( ( ( ruleQPREF ) )? otherlv_1= ';' )* )
            // InternalContract.g:490:2: ( ( ( ruleQPREF ) )? otherlv_1= ';' )*
            {
            // InternalContract.g:490:2: ( ( ( ruleQPREF ) )? otherlv_1= ';' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID||LA15_0==28) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalContract.g:491:3: ( ( ruleQPREF ) )? otherlv_1= ';'
            	    {
            	    // InternalContract.g:491:3: ( ( ruleQPREF ) )?
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==RULE_ID) ) {
            	        alt14=1;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // InternalContract.g:492:4: ( ruleQPREF )
            	            {
            	            // InternalContract.g:492:4: ( ruleQPREF )
            	            // InternalContract.g:493:5: ruleQPREF
            	            {

            	            					if (current==null) {
            	            						current = createModelElement(grammarAccess.getDomainsRule());
            	            					}
            	            				

            	            					newCompositeNode(grammarAccess.getDomainsAccess().getDomainsDomainCrossReference_0_0());
            	            				
            	            pushFollow(FOLLOW_17);
            	            ruleQPREF();

            	            state._fsp--;


            	            					afterParserOrEnumRuleCall();
            	            				

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_1=(Token)match(input,28,FOLLOW_22); 

            	    			newLeafNode(otherlv_1, grammarAccess.getDomainsAccess().getSemicolonKeyword_1());
            	    		

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomains"


    // $ANTLR start "ruleAssumptions"
    // InternalContract.g:516:1: ruleAssumptions[EObject in_current] returns [EObject current=in_current] : ( ( (lv_assumptions_0_0= ruleAssumptionElement ) )? otherlv_1= ';' )* ;
    public final EObject ruleAssumptions(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_assumptions_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:522:2: ( ( ( (lv_assumptions_0_0= ruleAssumptionElement ) )? otherlv_1= ';' )* )
            // InternalContract.g:523:2: ( ( (lv_assumptions_0_0= ruleAssumptionElement ) )? otherlv_1= ';' )*
            {
            // InternalContract.g:523:2: ( ( (lv_assumptions_0_0= ruleAssumptionElement ) )? otherlv_1= ';' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_SSTRING && LA17_0<=RULE_ISTRING_LEFT)||LA17_0==21||LA17_0==28||LA17_0==34||(LA17_0>=80 && LA17_0<=82)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalContract.g:524:3: ( (lv_assumptions_0_0= ruleAssumptionElement ) )? otherlv_1= ';'
            	    {
            	    // InternalContract.g:524:3: ( (lv_assumptions_0_0= ruleAssumptionElement ) )?
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( ((LA16_0>=RULE_SSTRING && LA16_0<=RULE_ISTRING_LEFT)||LA16_0==21||LA16_0==34||(LA16_0>=80 && LA16_0<=82)) ) {
            	        alt16=1;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // InternalContract.g:525:4: (lv_assumptions_0_0= ruleAssumptionElement )
            	            {
            	            // InternalContract.g:525:4: (lv_assumptions_0_0= ruleAssumptionElement )
            	            // InternalContract.g:526:5: lv_assumptions_0_0= ruleAssumptionElement
            	            {

            	            					newCompositeNode(grammarAccess.getAssumptionsAccess().getAssumptionsAssumptionElementParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_17);
            	            lv_assumptions_0_0=ruleAssumptionElement();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getAssumptionsRule());
            	            					}
            	            					add(
            	            						current,
            	            						"assumptions",
            	            						lv_assumptions_0_0,
            	            						"org.osate.contract.Contract.AssumptionElement");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_1=(Token)match(input,28,FOLLOW_23); 

            	    			newLeafNode(otherlv_1, grammarAccess.getAssumptionsAccess().getSemicolonKeyword_1());
            	    		

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssumptions"


    // $ANTLR start "ruleAnalyses"
    // InternalContract.g:552:1: ruleAnalyses[EObject in_current] returns [EObject current=in_current] : ( ( (lv_analyses_0_0= ruleAnalysis ) )? otherlv_1= ';' )* ;
    public final EObject ruleAnalyses(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_analyses_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:558:2: ( ( ( (lv_analyses_0_0= ruleAnalysis ) )? otherlv_1= ';' )* )
            // InternalContract.g:559:2: ( ( (lv_analyses_0_0= ruleAnalysis ) )? otherlv_1= ';' )*
            {
            // InternalContract.g:559:2: ( ( (lv_analyses_0_0= ruleAnalysis ) )? otherlv_1= ';' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_SSTRING && LA19_0<=RULE_ISTRING_LEFT)||LA19_0==28||(LA19_0>=80 && LA19_0<=82)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalContract.g:560:3: ( (lv_analyses_0_0= ruleAnalysis ) )? otherlv_1= ';'
            	    {
            	    // InternalContract.g:560:3: ( (lv_analyses_0_0= ruleAnalysis ) )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( ((LA18_0>=RULE_SSTRING && LA18_0<=RULE_ISTRING_LEFT)||(LA18_0>=80 && LA18_0<=82)) ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // InternalContract.g:561:4: (lv_analyses_0_0= ruleAnalysis )
            	            {
            	            // InternalContract.g:561:4: (lv_analyses_0_0= ruleAnalysis )
            	            // InternalContract.g:562:5: lv_analyses_0_0= ruleAnalysis
            	            {

            	            					newCompositeNode(grammarAccess.getAnalysesAccess().getAnalysesAnalysisParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_17);
            	            lv_analyses_0_0=ruleAnalysis();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getAnalysesRule());
            	            					}
            	            					add(
            	            						current,
            	            						"analyses",
            	            						lv_analyses_0_0,
            	            						"org.osate.contract.Contract.Analysis");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_1=(Token)match(input,28,FOLLOW_24); 

            	    			newLeafNode(otherlv_1, grammarAccess.getAnalysesAccess().getSemicolonKeyword_1());
            	    		

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnalyses"


    // $ANTLR start "entryRuleInputAssumption"
    // InternalContract.g:587:1: entryRuleInputAssumption returns [EObject current=null] : iv_ruleInputAssumption= ruleInputAssumption EOF ;
    public final EObject entryRuleInputAssumption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputAssumption = null;


        try {
            // InternalContract.g:587:56: (iv_ruleInputAssumption= ruleInputAssumption EOF )
            // InternalContract.g:588:2: iv_ruleInputAssumption= ruleInputAssumption EOF
            {
             newCompositeNode(grammarAccess.getInputAssumptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInputAssumption=ruleInputAssumption();

            state._fsp--;

             current =iv_ruleInputAssumption; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInputAssumption"


    // $ANTLR start "ruleInputAssumption"
    // InternalContract.g:594:1: ruleInputAssumption returns [EObject current=null] : ( () ( (lv_code_1_0= ruleSource ) )? otherlv_2= ';' ) ;
    public final EObject ruleInputAssumption() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_code_1_0 = null;



        	enterRule();

        try {
            // InternalContract.g:600:2: ( ( () ( (lv_code_1_0= ruleSource ) )? otherlv_2= ';' ) )
            // InternalContract.g:601:2: ( () ( (lv_code_1_0= ruleSource ) )? otherlv_2= ';' )
            {
            // InternalContract.g:601:2: ( () ( (lv_code_1_0= ruleSource ) )? otherlv_2= ';' )
            // InternalContract.g:602:3: () ( (lv_code_1_0= ruleSource ) )? otherlv_2= ';'
            {
            // InternalContract.g:602:3: ()
            // InternalContract.g:603:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInputAssumptionAccess().getInputAssumptionAction_0(),
            					current);
            			

            }

            // InternalContract.g:609:3: ( (lv_code_1_0= ruleSource ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_SSTRING && LA20_0<=RULE_ISTRING_LEFT)||(LA20_0>=80 && LA20_0<=82)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalContract.g:610:4: (lv_code_1_0= ruleSource )
                    {
                    // InternalContract.g:610:4: (lv_code_1_0= ruleSource )
                    // InternalContract.g:611:5: lv_code_1_0= ruleSource
                    {

                    					newCompositeNode(grammarAccess.getInputAssumptionAccess().getCodeSourceParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_17);
                    lv_code_1_0=ruleSource();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInputAssumptionRule());
                    					}
                    					set(
                    						current,
                    						"code",
                    						lv_code_1_0,
                    						"org.osate.contract.Contract.Source");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getInputAssumptionAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInputAssumption"


    // $ANTLR start "entryRuleAssumptionElement"
    // InternalContract.g:636:1: entryRuleAssumptionElement returns [EObject current=null] : iv_ruleAssumptionElement= ruleAssumptionElement EOF ;
    public final EObject entryRuleAssumptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssumptionElement = null;


        try {
            // InternalContract.g:636:58: (iv_ruleAssumptionElement= ruleAssumptionElement EOF )
            // InternalContract.g:637:2: iv_ruleAssumptionElement= ruleAssumptionElement EOF
            {
             newCompositeNode(grammarAccess.getAssumptionElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssumptionElement=ruleAssumptionElement();

            state._fsp--;

             current =iv_ruleAssumptionElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssumptionElement"


    // $ANTLR start "ruleAssumptionElement"
    // InternalContract.g:643:1: ruleAssumptionElement returns [EObject current=null] : ( ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) ) | ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) ) | ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? ) ) ;
    public final EObject ruleAssumptionElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_code_7_0 = null;

        EObject this_Exact_8 = null;

        EObject lv_guarantee_9_0 = null;



        	enterRule();

        try {
            // InternalContract.g:649:2: ( ( ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) ) | ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) ) | ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? ) ) )
            // InternalContract.g:650:2: ( ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) ) | ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) ) | ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? ) )
            {
            // InternalContract.g:650:2: ( ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) ) | ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) ) | ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt22=1;
                }
                break;
            case 34:
                {
                alt22=2;
                }
                break;
            case RULE_SSTRING:
            case RULE_ISTRING_TEXT:
            case RULE_ISTRING_LEFT:
            case 80:
            case 81:
            case 82:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalContract.g:651:3: ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) )
                    {
                    // InternalContract.g:651:3: ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) )
                    // InternalContract.g:652:4: () otherlv_1= 'contract' ( ( ruleQPREF ) )
                    {
                    // InternalContract.g:652:4: ()
                    // InternalContract.g:653:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAssumptionElementAccess().getContractAssumptionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getAssumptionElementAccess().getContractKeyword_0_1());
                    			
                    // InternalContract.g:663:4: ( ( ruleQPREF ) )
                    // InternalContract.g:664:5: ( ruleQPREF )
                    {
                    // InternalContract.g:664:5: ( ruleQPREF )
                    // InternalContract.g:665:6: ruleQPREF
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssumptionElementRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAssumptionElementAccess().getContractContractElementCrossReference_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleQPREF();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:681:3: ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) )
                    {
                    // InternalContract.g:681:3: ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) )
                    // InternalContract.g:682:4: () otherlv_4= 'argument' ( ( ruleQPREF ) )
                    {
                    // InternalContract.g:682:4: ()
                    // InternalContract.g:683:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAssumptionElementAccess().getArgumentAssumptionAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_4=(Token)match(input,34,FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getAssumptionElementAccess().getArgumentKeyword_1_1());
                    			
                    // InternalContract.g:693:4: ( ( ruleQPREF ) )
                    // InternalContract.g:694:5: ( ruleQPREF )
                    {
                    // InternalContract.g:694:5: ( ruleQPREF )
                    // InternalContract.g:695:6: ruleQPREF
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssumptionElementRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAssumptionElementAccess().getArgumentContractElementCrossReference_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleQPREF();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalContract.g:711:3: ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? )
                    {
                    // InternalContract.g:711:3: ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? )
                    // InternalContract.g:712:4: () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )?
                    {
                    // InternalContract.g:712:4: ()
                    // InternalContract.g:713:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAssumptionElementAccess().getCodeAssumptionAction_2_0(),
                    						current);
                    				

                    }

                    // InternalContract.g:719:4: ( (lv_code_7_0= ruleSource ) )
                    // InternalContract.g:720:5: (lv_code_7_0= ruleSource )
                    {
                    // InternalContract.g:720:5: (lv_code_7_0= ruleSource )
                    // InternalContract.g:721:6: lv_code_7_0= ruleSource
                    {

                    						newCompositeNode(grammarAccess.getAssumptionElementAccess().getCodeSourceParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_code_7_0=ruleSource();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAssumptionElementRule());
                    						}
                    						set(
                    							current,
                    							"code",
                    							lv_code_7_0,
                    							"org.osate.contract.Contract.Source");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:738:4: (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=32 && LA21_0<=33)) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalContract.g:739:5: this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) )
                            {

                            					if (current==null) {
                            						current = createModelElement(grammarAccess.getAssumptionElementRule());
                            					}
                            					newCompositeNode(grammarAccess.getAssumptionElementAccess().getExactParserRuleCall_2_2_0());
                            				
                            pushFollow(FOLLOW_16);
                            this_Exact_8=ruleExact(current);

                            state._fsp--;


                            					current = this_Exact_8;
                            					afterParserOrEnumRuleCall();
                            				
                            // InternalContract.g:750:5: ( (lv_guarantee_9_0= ruleGuarantee ) )
                            // InternalContract.g:751:6: (lv_guarantee_9_0= ruleGuarantee )
                            {
                            // InternalContract.g:751:6: (lv_guarantee_9_0= ruleGuarantee )
                            // InternalContract.g:752:7: lv_guarantee_9_0= ruleGuarantee
                            {

                            							newCompositeNode(grammarAccess.getAssumptionElementAccess().getGuaranteeGuaranteeParserRuleCall_2_2_1_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_guarantee_9_0=ruleGuarantee();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAssumptionElementRule());
                            							}
                            							set(
                            								current,
                            								"guarantee",
                            								lv_guarantee_9_0,
                            								"org.osate.contract.Contract.Guarantee");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssumptionElement"


    // $ANTLR start "entryRuleGuarantee"
    // InternalContract.g:775:1: entryRuleGuarantee returns [EObject current=null] : iv_ruleGuarantee= ruleGuarantee EOF ;
    public final EObject entryRuleGuarantee() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuarantee = null;


        try {
            // InternalContract.g:775:50: (iv_ruleGuarantee= ruleGuarantee EOF )
            // InternalContract.g:776:2: iv_ruleGuarantee= ruleGuarantee EOF
            {
             newCompositeNode(grammarAccess.getGuaranteeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGuarantee=ruleGuarantee();

            state._fsp--;

             current =iv_ruleGuarantee; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuarantee"


    // $ANTLR start "ruleGuarantee"
    // InternalContract.g:782:1: ruleGuarantee returns [EObject current=null] : ( (lv_code_0_0= ruleSource ) ) ;
    public final EObject ruleGuarantee() throws RecognitionException {
        EObject current = null;

        EObject lv_code_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:788:2: ( ( (lv_code_0_0= ruleSource ) ) )
            // InternalContract.g:789:2: ( (lv_code_0_0= ruleSource ) )
            {
            // InternalContract.g:789:2: ( (lv_code_0_0= ruleSource ) )
            // InternalContract.g:790:3: (lv_code_0_0= ruleSource )
            {
            // InternalContract.g:790:3: (lv_code_0_0= ruleSource )
            // InternalContract.g:791:4: lv_code_0_0= ruleSource
            {

            				newCompositeNode(grammarAccess.getGuaranteeAccess().getCodeSourceParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_code_0_0=ruleSource();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getGuaranteeRule());
            				}
            				set(
            					current,
            					"code",
            					lv_code_0_0,
            					"org.osate.contract.Contract.Source");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuarantee"


    // $ANTLR start "entryRuleAnalysis"
    // InternalContract.g:811:1: entryRuleAnalysis returns [EObject current=null] : iv_ruleAnalysis= ruleAnalysis EOF ;
    public final EObject entryRuleAnalysis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnalysis = null;


        try {
            // InternalContract.g:811:49: (iv_ruleAnalysis= ruleAnalysis EOF )
            // InternalContract.g:812:2: iv_ruleAnalysis= ruleAnalysis EOF
            {
             newCompositeNode(grammarAccess.getAnalysisRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnalysis=ruleAnalysis();

            state._fsp--;

             current =iv_ruleAnalysis; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnalysis"


    // $ANTLR start "ruleAnalysis"
    // InternalContract.g:818:1: ruleAnalysis returns [EObject current=null] : ( (lv_code_0_0= ruleSource ) ) ;
    public final EObject ruleAnalysis() throws RecognitionException {
        EObject current = null;

        EObject lv_code_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:824:2: ( ( (lv_code_0_0= ruleSource ) ) )
            // InternalContract.g:825:2: ( (lv_code_0_0= ruleSource ) )
            {
            // InternalContract.g:825:2: ( (lv_code_0_0= ruleSource ) )
            // InternalContract.g:826:3: (lv_code_0_0= ruleSource )
            {
            // InternalContract.g:826:3: (lv_code_0_0= ruleSource )
            // InternalContract.g:827:4: lv_code_0_0= ruleSource
            {

            				newCompositeNode(grammarAccess.getAnalysisAccess().getCodeSourceParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_code_0_0=ruleSource();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getAnalysisRule());
            				}
            				set(
            					current,
            					"code",
            					lv_code_0_0,
            					"org.osate.contract.Contract.Source");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnalysis"


    // $ANTLR start "entryRuleSource"
    // InternalContract.g:847:1: entryRuleSource returns [EObject current=null] : iv_ruleSource= ruleSource EOF ;
    public final EObject entryRuleSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSource = null;


        try {
            // InternalContract.g:847:47: (iv_ruleSource= ruleSource EOF )
            // InternalContract.g:848:2: iv_ruleSource= ruleSource EOF
            {
             newCompositeNode(grammarAccess.getSourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSource=ruleSource();

            state._fsp--;

             current =iv_ruleSource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSource"


    // $ANTLR start "ruleSource"
    // InternalContract.g:854:1: ruleSource returns [EObject current=null] : ( ( (lv_language_0_0= ruleLanguage ) )? ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) ) ) ;
    public final EObject ruleSource() throws RecognitionException {
        EObject current = null;

        Token lv_source_1_0=null;
        Enumerator lv_language_0_0 = null;

        EObject lv_inter_2_0 = null;



        	enterRule();

        try {
            // InternalContract.g:860:2: ( ( ( (lv_language_0_0= ruleLanguage ) )? ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) ) ) )
            // InternalContract.g:861:2: ( ( (lv_language_0_0= ruleLanguage ) )? ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) ) )
            {
            // InternalContract.g:861:2: ( ( (lv_language_0_0= ruleLanguage ) )? ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) ) )
            // InternalContract.g:862:3: ( (lv_language_0_0= ruleLanguage ) )? ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) )
            {
            // InternalContract.g:862:3: ( (lv_language_0_0= ruleLanguage ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=80 && LA23_0<=82)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalContract.g:863:4: (lv_language_0_0= ruleLanguage )
                    {
                    // InternalContract.g:863:4: (lv_language_0_0= ruleLanguage )
                    // InternalContract.g:864:5: lv_language_0_0= ruleLanguage
                    {

                    					newCompositeNode(grammarAccess.getSourceAccess().getLanguageLanguageEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_16);
                    lv_language_0_0=ruleLanguage();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSourceRule());
                    					}
                    					set(
                    						current,
                    						"language",
                    						lv_language_0_0,
                    						"org.osate.contract.Contract.Language");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalContract.g:881:3: ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_SSTRING) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=RULE_ISTRING_TEXT && LA24_0<=RULE_ISTRING_LEFT)) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalContract.g:882:4: ( (lv_source_1_0= RULE_SSTRING ) )
                    {
                    // InternalContract.g:882:4: ( (lv_source_1_0= RULE_SSTRING ) )
                    // InternalContract.g:883:5: (lv_source_1_0= RULE_SSTRING )
                    {
                    // InternalContract.g:883:5: (lv_source_1_0= RULE_SSTRING )
                    // InternalContract.g:884:6: lv_source_1_0= RULE_SSTRING
                    {
                    lv_source_1_0=(Token)match(input,RULE_SSTRING,FOLLOW_2); 

                    						newLeafNode(lv_source_1_0, grammarAccess.getSourceAccess().getSourceSSTRINGTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSourceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"source",
                    							lv_source_1_0,
                    							"org.osate.contract.Contract.SSTRING");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:901:4: ( (lv_inter_2_0= ruleIString ) )
                    {
                    // InternalContract.g:901:4: ( (lv_inter_2_0= ruleIString ) )
                    // InternalContract.g:902:5: (lv_inter_2_0= ruleIString )
                    {
                    // InternalContract.g:902:5: (lv_inter_2_0= ruleIString )
                    // InternalContract.g:903:6: lv_inter_2_0= ruleIString
                    {

                    						newCompositeNode(grammarAccess.getSourceAccess().getInterIStringParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_inter_2_0=ruleIString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSourceRule());
                    						}
                    						set(
                    							current,
                    							"inter",
                    							lv_inter_2_0,
                    							"org.osate.contract.Contract.IString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSource"


    // $ANTLR start "entryRuleImplementation"
    // InternalContract.g:925:1: entryRuleImplementation returns [EObject current=null] : iv_ruleImplementation= ruleImplementation EOF ;
    public final EObject entryRuleImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplementation = null;


        try {
            // InternalContract.g:925:55: (iv_ruleImplementation= ruleImplementation EOF )
            // InternalContract.g:926:2: iv_ruleImplementation= ruleImplementation EOF
            {
             newCompositeNode(grammarAccess.getImplementationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImplementation=ruleImplementation();

            state._fsp--;

             current =iv_ruleImplementation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplementation"


    // $ANTLR start "ruleImplementation"
    // InternalContract.g:932:1: ruleImplementation returns [EObject current=null] : (otherlv_0= 'contract' otherlv_1= 'implementation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_code_4_0= ruleSource ) ) otherlv_5= '}' ) ;
    public final EObject ruleImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_code_4_0 = null;



        	enterRule();

        try {
            // InternalContract.g:938:2: ( (otherlv_0= 'contract' otherlv_1= 'implementation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_code_4_0= ruleSource ) ) otherlv_5= '}' ) )
            // InternalContract.g:939:2: (otherlv_0= 'contract' otherlv_1= 'implementation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_code_4_0= ruleSource ) ) otherlv_5= '}' )
            {
            // InternalContract.g:939:2: (otherlv_0= 'contract' otherlv_1= 'implementation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_code_4_0= ruleSource ) ) otherlv_5= '}' )
            // InternalContract.g:940:3: otherlv_0= 'contract' otherlv_1= 'implementation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_code_4_0= ruleSource ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getImplementationAccess().getContractKeyword_0());
            		
            otherlv_1=(Token)match(input,35,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getImplementationAccess().getImplementationKeyword_1());
            		
            // InternalContract.g:948:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalContract.g:949:4: (lv_name_2_0= RULE_ID )
            {
            // InternalContract.g:949:4: (lv_name_2_0= RULE_ID )
            // InternalContract.g:950:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_2_0, grammarAccess.getImplementationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImplementationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.osate.xtext.aadl2.properties.Properties.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getImplementationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalContract.g:970:3: ( (lv_code_4_0= ruleSource ) )
            // InternalContract.g:971:4: (lv_code_4_0= ruleSource )
            {
            // InternalContract.g:971:4: (lv_code_4_0= ruleSource )
            // InternalContract.g:972:5: lv_code_4_0= ruleSource
            {

            					newCompositeNode(grammarAccess.getImplementationAccess().getCodeSourceParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_20);
            lv_code_4_0=ruleSource();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImplementationRule());
            					}
            					set(
            						current,
            						"code",
            						lv_code_4_0,
            						"org.osate.contract.Contract.Source");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,31,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getImplementationAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplementation"


    // $ANTLR start "entryRuleDomain"
    // InternalContract.g:997:1: entryRuleDomain returns [EObject current=null] : iv_ruleDomain= ruleDomain EOF ;
    public final EObject entryRuleDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomain = null;


        try {
            // InternalContract.g:997:47: (iv_ruleDomain= ruleDomain EOF )
            // InternalContract.g:998:2: iv_ruleDomain= ruleDomain EOF
            {
             newCompositeNode(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomain=ruleDomain();

            state._fsp--;

             current =iv_ruleDomain; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomain"


    // $ANTLR start "ruleDomain"
    // InternalContract.g:1004:1: ruleDomain returns [EObject current=null] : (otherlv_0= 'domain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )? (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject this_Queries_4 = null;

        EObject lv_code_6_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1010:2: ( (otherlv_0= 'domain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )? (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )? otherlv_7= '}' ) )
            // InternalContract.g:1011:2: (otherlv_0= 'domain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )? (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )? otherlv_7= '}' )
            {
            // InternalContract.g:1011:2: (otherlv_0= 'domain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )? (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )? otherlv_7= '}' )
            // InternalContract.g:1012:3: otherlv_0= 'domain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )? (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDomainAccess().getDomainKeyword_0());
            		
            // InternalContract.g:1016:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:1017:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:1017:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:1018:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDomainAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDomainRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.osate.xtext.aadl2.properties.Properties.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getDomainAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalContract.g:1038:3: (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==24) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalContract.g:1039:4: otherlv_3= 'queries' this_Queries_4= ruleQueries[$current]
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_28); 

                    				newLeafNode(otherlv_3, grammarAccess.getDomainAccess().getQueriesKeyword_3_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getDomainRule());
                    				}
                    				newCompositeNode(grammarAccess.getDomainAccess().getQueriesParserRuleCall_3_1());
                    			
                    pushFollow(FOLLOW_29);
                    this_Queries_4=ruleQueries(current);

                    state._fsp--;


                    				current = this_Queries_4;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:1055:3: (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalContract.g:1056:4: otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) )
                    {
                    otherlv_5=(Token)match(input,37,FOLLOW_16); 

                    				newLeafNode(otherlv_5, grammarAccess.getDomainAccess().getDeclarationsKeyword_4_0());
                    			
                    // InternalContract.g:1060:4: ( (lv_code_6_0= ruleSource ) )
                    // InternalContract.g:1061:5: (lv_code_6_0= ruleSource )
                    {
                    // InternalContract.g:1061:5: (lv_code_6_0= ruleSource )
                    // InternalContract.g:1062:6: lv_code_6_0= ruleSource
                    {

                    						newCompositeNode(grammarAccess.getDomainAccess().getCodeSourceParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_code_6_0=ruleSource();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDomainRule());
                    						}
                    						set(
                    							current,
                    							"code",
                    							lv_code_6_0,
                    							"org.osate.contract.Contract.Source");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,31,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDomainAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomain"


    // $ANTLR start "entryRuleArgument"
    // InternalContract.g:1088:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalContract.g:1088:49: (iv_ruleArgument= ruleArgument EOF )
            // InternalContract.g:1089:2: iv_ruleArgument= ruleArgument EOF
            {
             newCompositeNode(grammarAccess.getArgumentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArgument=ruleArgument();

            state._fsp--;

             current =iv_ruleArgument; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgument"


    // $ANTLR start "ruleArgument"
    // InternalContract.g:1095:1: ruleArgument returns [EObject current=null] : (otherlv_0= 'argument' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )? (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) )? otherlv_11= '}' ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject this_Domains_4 = null;

        EObject this_Exact_6 = null;

        EObject lv_guarantee_7_0 = null;

        EObject lv_argumentExpression_10_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1101:2: ( (otherlv_0= 'argument' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )? (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) )? otherlv_11= '}' ) )
            // InternalContract.g:1102:2: (otherlv_0= 'argument' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )? (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) )? otherlv_11= '}' )
            {
            // InternalContract.g:1102:2: (otherlv_0= 'argument' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )? (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) )? otherlv_11= '}' )
            // InternalContract.g:1103:3: otherlv_0= 'argument' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )? (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getArgumentAccess().getArgumentKeyword_0());
            		
            // InternalContract.g:1107:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:1108:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:1108:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:1109:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArgumentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.osate.xtext.aadl2.properties.Properties.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getArgumentAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalContract.g:1129:3: (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==23) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalContract.g:1130:4: otherlv_3= 'domains' this_Domains_4= ruleDomains[$current]
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_31); 

                    				newLeafNode(otherlv_3, grammarAccess.getArgumentAccess().getDomainsKeyword_3_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getArgumentRule());
                    				}
                    				newCompositeNode(grammarAccess.getArgumentAccess().getDomainsParserRuleCall_3_1());
                    			
                    pushFollow(FOLLOW_32);
                    this_Domains_4=ruleDomains(current);

                    state._fsp--;


                    				current = this_Domains_4;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:1146:3: (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==27) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalContract.g:1147:4: otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';'
                    {
                    otherlv_5=(Token)match(input,27,FOLLOW_15); 

                    				newLeafNode(otherlv_5, grammarAccess.getArgumentAccess().getGuaranteeKeyword_4_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getArgumentRule());
                    				}
                    				newCompositeNode(grammarAccess.getArgumentAccess().getExactParserRuleCall_4_1());
                    			
                    pushFollow(FOLLOW_16);
                    this_Exact_6=ruleExact(current);

                    state._fsp--;


                    				current = this_Exact_6;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalContract.g:1162:4: ( (lv_guarantee_7_0= ruleGuarantee ) )
                    // InternalContract.g:1163:5: (lv_guarantee_7_0= ruleGuarantee )
                    {
                    // InternalContract.g:1163:5: (lv_guarantee_7_0= ruleGuarantee )
                    // InternalContract.g:1164:6: lv_guarantee_7_0= ruleGuarantee
                    {

                    						newCompositeNode(grammarAccess.getArgumentAccess().getGuaranteeGuaranteeParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_guarantee_7_0=ruleGuarantee();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArgumentRule());
                    						}
                    						set(
                    							current,
                    							"guarantee",
                    							lv_guarantee_7_0,
                    							"org.osate.contract.Contract.Guarantee");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,28,FOLLOW_33); 

                    				newLeafNode(otherlv_8, grammarAccess.getArgumentAccess().getSemicolonKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalContract.g:1186:3: (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalContract.g:1187:4: otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) )
                    {
                    otherlv_9=(Token)match(input,34,FOLLOW_34); 

                    				newLeafNode(otherlv_9, grammarAccess.getArgumentAccess().getArgumentKeyword_5_0());
                    			
                    // InternalContract.g:1191:4: ( (lv_argumentExpression_10_0= ruleArgumentExpression ) )
                    // InternalContract.g:1192:5: (lv_argumentExpression_10_0= ruleArgumentExpression )
                    {
                    // InternalContract.g:1192:5: (lv_argumentExpression_10_0= ruleArgumentExpression )
                    // InternalContract.g:1193:6: lv_argumentExpression_10_0= ruleArgumentExpression
                    {

                    						newCompositeNode(grammarAccess.getArgumentAccess().getArgumentExpressionArgumentExpressionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_argumentExpression_10_0=ruleArgumentExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArgumentRule());
                    						}
                    						set(
                    							current,
                    							"argumentExpression",
                    							lv_argumentExpression_10_0,
                    							"org.osate.contract.Contract.ArgumentExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,31,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getArgumentAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleArgumentExpression"
    // InternalContract.g:1219:1: entryRuleArgumentExpression returns [EObject current=null] : iv_ruleArgumentExpression= ruleArgumentExpression EOF ;
    public final EObject entryRuleArgumentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentExpression = null;


        try {
            // InternalContract.g:1219:59: (iv_ruleArgumentExpression= ruleArgumentExpression EOF )
            // InternalContract.g:1220:2: iv_ruleArgumentExpression= ruleArgumentExpression EOF
            {
             newCompositeNode(grammarAccess.getArgumentExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArgumentExpression=ruleArgumentExpression();

            state._fsp--;

             current =iv_ruleArgumentExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgumentExpression"


    // $ANTLR start "ruleArgumentExpression"
    // InternalContract.g:1226:1: ruleArgumentExpression returns [EObject current=null] : ( () otherlv_1= 'or' otherlv_2= '(' ( (otherlv_3= 'contract' ( ( ruleQPREF ) ) ) | (otherlv_5= 'argument' ( ( ruleQPREF ) ) ) )* otherlv_7= ')' otherlv_8= ';' ) ;
    public final EObject ruleArgumentExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalContract.g:1232:2: ( ( () otherlv_1= 'or' otherlv_2= '(' ( (otherlv_3= 'contract' ( ( ruleQPREF ) ) ) | (otherlv_5= 'argument' ( ( ruleQPREF ) ) ) )* otherlv_7= ')' otherlv_8= ';' ) )
            // InternalContract.g:1233:2: ( () otherlv_1= 'or' otherlv_2= '(' ( (otherlv_3= 'contract' ( ( ruleQPREF ) ) ) | (otherlv_5= 'argument' ( ( ruleQPREF ) ) ) )* otherlv_7= ')' otherlv_8= ';' )
            {
            // InternalContract.g:1233:2: ( () otherlv_1= 'or' otherlv_2= '(' ( (otherlv_3= 'contract' ( ( ruleQPREF ) ) ) | (otherlv_5= 'argument' ( ( ruleQPREF ) ) ) )* otherlv_7= ')' otherlv_8= ';' )
            // InternalContract.g:1234:3: () otherlv_1= 'or' otherlv_2= '(' ( (otherlv_3= 'contract' ( ( ruleQPREF ) ) ) | (otherlv_5= 'argument' ( ( ruleQPREF ) ) ) )* otherlv_7= ')' otherlv_8= ';'
            {
            // InternalContract.g:1234:3: ()
            // InternalContract.g:1235:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArgumentExpressionAccess().getArgumentExpressionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,38,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getArgumentExpressionAccess().getOrKeyword_1());
            		
            otherlv_2=(Token)match(input,39,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getArgumentExpressionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalContract.g:1249:3: ( (otherlv_3= 'contract' ( ( ruleQPREF ) ) ) | (otherlv_5= 'argument' ( ( ruleQPREF ) ) ) )*
            loop30:
            do {
                int alt30=3;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==21) ) {
                    alt30=1;
                }
                else if ( (LA30_0==34) ) {
                    alt30=2;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalContract.g:1250:4: (otherlv_3= 'contract' ( ( ruleQPREF ) ) )
            	    {
            	    // InternalContract.g:1250:4: (otherlv_3= 'contract' ( ( ruleQPREF ) ) )
            	    // InternalContract.g:1251:5: otherlv_3= 'contract' ( ( ruleQPREF ) )
            	    {
            	    otherlv_3=(Token)match(input,21,FOLLOW_4); 

            	    					newLeafNode(otherlv_3, grammarAccess.getArgumentExpressionAccess().getContractKeyword_3_0_0());
            	    				
            	    // InternalContract.g:1255:5: ( ( ruleQPREF ) )
            	    // InternalContract.g:1256:6: ( ruleQPREF )
            	    {
            	    // InternalContract.g:1256:6: ( ruleQPREF )
            	    // InternalContract.g:1257:7: ruleQPREF
            	    {

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getArgumentExpressionRule());
            	    							}
            	    						

            	    							newCompositeNode(grammarAccess.getArgumentExpressionAccess().getContractsContractElementCrossReference_3_0_1_0());
            	    						
            	    pushFollow(FOLLOW_36);
            	    ruleQPREF();

            	    state._fsp--;


            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalContract.g:1273:4: (otherlv_5= 'argument' ( ( ruleQPREF ) ) )
            	    {
            	    // InternalContract.g:1273:4: (otherlv_5= 'argument' ( ( ruleQPREF ) ) )
            	    // InternalContract.g:1274:5: otherlv_5= 'argument' ( ( ruleQPREF ) )
            	    {
            	    otherlv_5=(Token)match(input,34,FOLLOW_4); 

            	    					newLeafNode(otherlv_5, grammarAccess.getArgumentExpressionAccess().getArgumentKeyword_3_1_0());
            	    				
            	    // InternalContract.g:1278:5: ( ( ruleQPREF ) )
            	    // InternalContract.g:1279:6: ( ruleQPREF )
            	    {
            	    // InternalContract.g:1279:6: ( ruleQPREF )
            	    // InternalContract.g:1280:7: ruleQPREF
            	    {

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getArgumentExpressionRule());
            	    							}
            	    						

            	    							newCompositeNode(grammarAccess.getArgumentExpressionAccess().getArgumentsContractElementCrossReference_3_1_1_0());
            	    						
            	    pushFollow(FOLLOW_36);
            	    ruleQPREF();

            	    state._fsp--;


            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_7=(Token)match(input,40,FOLLOW_17); 

            			newLeafNode(otherlv_7, grammarAccess.getArgumentExpressionAccess().getRightParenthesisKeyword_4());
            		
            otherlv_8=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getArgumentExpressionAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgumentExpression"


    // $ANTLR start "entryRuleVerificationPlan"
    // InternalContract.g:1308:1: entryRuleVerificationPlan returns [EObject current=null] : iv_ruleVerificationPlan= ruleVerificationPlan EOF ;
    public final EObject entryRuleVerificationPlan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationPlan = null;


        try {
            // InternalContract.g:1308:57: (iv_ruleVerificationPlan= ruleVerificationPlan EOF )
            // InternalContract.g:1309:2: iv_ruleVerificationPlan= ruleVerificationPlan EOF
            {
             newCompositeNode(grammarAccess.getVerificationPlanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVerificationPlan=ruleVerificationPlan();

            state._fsp--;

             current =iv_ruleVerificationPlan; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVerificationPlan"


    // $ANTLR start "ruleVerificationPlan"
    // InternalContract.g:1315:1: ruleVerificationPlan returns [EObject current=null] : (otherlv_0= 'verification' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'component' this_ID_5= RULE_ID otherlv_6= ':' ( ( ruleQCREF ) ) otherlv_8= ';' (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )? (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )? (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )? otherlv_16= '}' ) ;
    public final EObject ruleVerificationPlan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_ID_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        EObject this_Domains_10 = null;

        EObject this_Claims_12 = null;



        	enterRule();

        try {
            // InternalContract.g:1321:2: ( (otherlv_0= 'verification' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'component' this_ID_5= RULE_ID otherlv_6= ':' ( ( ruleQCREF ) ) otherlv_8= ';' (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )? (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )? (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )? otherlv_16= '}' ) )
            // InternalContract.g:1322:2: (otherlv_0= 'verification' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'component' this_ID_5= RULE_ID otherlv_6= ':' ( ( ruleQCREF ) ) otherlv_8= ';' (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )? (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )? (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )? otherlv_16= '}' )
            {
            // InternalContract.g:1322:2: (otherlv_0= 'verification' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'component' this_ID_5= RULE_ID otherlv_6= ':' ( ( ruleQCREF ) ) otherlv_8= ';' (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )? (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )? (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )? otherlv_16= '}' )
            // InternalContract.g:1323:3: otherlv_0= 'verification' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'component' this_ID_5= RULE_ID otherlv_6= ':' ( ( ruleQCREF ) ) otherlv_8= ';' (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )? (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )? (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getVerificationPlanAccess().getVerificationKeyword_0());
            		
            otherlv_1=(Token)match(input,42,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getVerificationPlanAccess().getPlanKeyword_1());
            		
            // InternalContract.g:1331:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalContract.g:1332:4: (lv_name_2_0= RULE_ID )
            {
            // InternalContract.g:1332:4: (lv_name_2_0= RULE_ID )
            // InternalContract.g:1333:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_2_0, grammarAccess.getVerificationPlanAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVerificationPlanRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.osate.xtext.aadl2.properties.Properties.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_38); 

            			newLeafNode(otherlv_3, grammarAccess.getVerificationPlanAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,43,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getVerificationPlanAccess().getComponentKeyword_4());
            		
            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_39); 

            			newLeafNode(this_ID_5, grammarAccess.getVerificationPlanAccess().getIDTerminalRuleCall_5());
            		
            otherlv_6=(Token)match(input,44,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getVerificationPlanAccess().getColonKeyword_6());
            		
            // InternalContract.g:1365:3: ( ( ruleQCREF ) )
            // InternalContract.g:1366:4: ( ruleQCREF )
            {
            // InternalContract.g:1366:4: ( ruleQCREF )
            // InternalContract.g:1367:5: ruleQCREF
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVerificationPlanRule());
            					}
            				

            					newCompositeNode(grammarAccess.getVerificationPlanAccess().getComponentImplementationComponentImplementationCrossReference_7_0());
            				
            pushFollow(FOLLOW_17);
            ruleQCREF();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,28,FOLLOW_40); 

            			newLeafNode(otherlv_8, grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_8());
            		
            // InternalContract.g:1385:3: (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==23) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalContract.g:1386:4: otherlv_9= 'domains' this_Domains_10= ruleDomains[$current]
                    {
                    otherlv_9=(Token)match(input,23,FOLLOW_41); 

                    				newLeafNode(otherlv_9, grammarAccess.getVerificationPlanAccess().getDomainsKeyword_9_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getVerificationPlanRule());
                    				}
                    				newCompositeNode(grammarAccess.getVerificationPlanAccess().getDomainsParserRuleCall_9_1());
                    			
                    pushFollow(FOLLOW_42);
                    this_Domains_10=ruleDomains(current);

                    state._fsp--;


                    				current = this_Domains_10;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:1402:3: (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==45) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalContract.g:1403:4: otherlv_11= 'claims' this_Claims_12= ruleClaims[$current]
                    {
                    otherlv_11=(Token)match(input,45,FOLLOW_43); 

                    				newLeafNode(otherlv_11, grammarAccess.getVerificationPlanAccess().getClaimsKeyword_10_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getVerificationPlanRule());
                    				}
                    				newCompositeNode(grammarAccess.getVerificationPlanAccess().getClaimsParserRuleCall_10_1());
                    			
                    pushFollow(FOLLOW_44);
                    this_Claims_12=ruleClaims(current);

                    state._fsp--;


                    				current = this_Claims_12;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:1419:3: (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==46) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalContract.g:1420:4: otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )*
                    {
                    otherlv_13=(Token)match(input,46,FOLLOW_45); 

                    				newLeafNode(otherlv_13, grammarAccess.getVerificationPlanAccess().getContractsKeyword_11_0());
                    			
                    // InternalContract.g:1424:4: ( ( ( ruleQPREF ) )? otherlv_15= ';' )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==RULE_ID||LA34_0==28) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalContract.g:1425:5: ( ( ruleQPREF ) )? otherlv_15= ';'
                    	    {
                    	    // InternalContract.g:1425:5: ( ( ruleQPREF ) )?
                    	    int alt33=2;
                    	    int LA33_0 = input.LA(1);

                    	    if ( (LA33_0==RULE_ID) ) {
                    	        alt33=1;
                    	    }
                    	    switch (alt33) {
                    	        case 1 :
                    	            // InternalContract.g:1426:6: ( ruleQPREF )
                    	            {
                    	            // InternalContract.g:1426:6: ( ruleQPREF )
                    	            // InternalContract.g:1427:7: ruleQPREF
                    	            {

                    	            							if (current==null) {
                    	            								current = createModelElement(grammarAccess.getVerificationPlanRule());
                    	            							}
                    	            						

                    	            							newCompositeNode(grammarAccess.getVerificationPlanAccess().getContractsContractCrossReference_11_1_0_0());
                    	            						
                    	            pushFollow(FOLLOW_17);
                    	            ruleQPREF();

                    	            state._fsp--;


                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }


                    	            }
                    	            break;

                    	    }

                    	    otherlv_15=(Token)match(input,28,FOLLOW_45); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_11_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_16=(Token)match(input,31,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getVerificationPlanAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVerificationPlan"


    // $ANTLR start "ruleClaims"
    // InternalContract.g:1456:1: ruleClaims[EObject in_current] returns [EObject current=in_current] : ( ( (lv_claims_0_0= ruleSource ) )? otherlv_1= ';' )* ;
    public final EObject ruleClaims(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_claims_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1462:2: ( ( ( (lv_claims_0_0= ruleSource ) )? otherlv_1= ';' )* )
            // InternalContract.g:1463:2: ( ( (lv_claims_0_0= ruleSource ) )? otherlv_1= ';' )*
            {
            // InternalContract.g:1463:2: ( ( (lv_claims_0_0= ruleSource ) )? otherlv_1= ';' )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_SSTRING && LA37_0<=RULE_ISTRING_LEFT)||LA37_0==28||(LA37_0>=80 && LA37_0<=82)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalContract.g:1464:3: ( (lv_claims_0_0= ruleSource ) )? otherlv_1= ';'
            	    {
            	    // InternalContract.g:1464:3: ( (lv_claims_0_0= ruleSource ) )?
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( ((LA36_0>=RULE_SSTRING && LA36_0<=RULE_ISTRING_LEFT)||(LA36_0>=80 && LA36_0<=82)) ) {
            	        alt36=1;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // InternalContract.g:1465:4: (lv_claims_0_0= ruleSource )
            	            {
            	            // InternalContract.g:1465:4: (lv_claims_0_0= ruleSource )
            	            // InternalContract.g:1466:5: lv_claims_0_0= ruleSource
            	            {

            	            					newCompositeNode(grammarAccess.getClaimsAccess().getClaimsSourceParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_17);
            	            lv_claims_0_0=ruleSource();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getClaimsRule());
            	            					}
            	            					add(
            	            						current,
            	            						"claims",
            	            						lv_claims_0_0,
            	            						"org.osate.contract.Contract.Source");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_1=(Token)match(input,28,FOLLOW_24); 

            	    			newLeafNode(otherlv_1, grammarAccess.getClaimsAccess().getSemicolonKeyword_1());
            	    		

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClaims"


    // $ANTLR start "entryRuleQuery"
    // InternalContract.g:1491:1: entryRuleQuery returns [EObject current=null] : iv_ruleQuery= ruleQuery EOF ;
    public final EObject entryRuleQuery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuery = null;


        try {
            // InternalContract.g:1491:46: (iv_ruleQuery= ruleQuery EOF )
            // InternalContract.g:1492:2: iv_ruleQuery= ruleQuery EOF
            {
             newCompositeNode(grammarAccess.getQueryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuery=ruleQuery();

            state._fsp--;

             current =iv_ruleQuery; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuery"


    // $ANTLR start "ruleQuery"
    // InternalContract.g:1498:1: ruleQuery returns [EObject current=null] : (this_SingleValDeclaration_0= ruleSingleValDeclaration | ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) ) ) ;
    public final EObject ruleQuery() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject this_SingleValDeclaration_0 = null;

        EObject lv_names_4_0 = null;

        EObject lv_names_6_0 = null;

        EObject lv_value_9_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1504:2: ( (this_SingleValDeclaration_0= ruleSingleValDeclaration | ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) ) ) )
            // InternalContract.g:1505:2: (this_SingleValDeclaration_0= ruleSingleValDeclaration | ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) ) )
            {
            // InternalContract.g:1505:2: (this_SingleValDeclaration_0= ruleSingleValDeclaration | ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==47) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==RULE_ID) ) {
                    alt39=1;
                }
                else if ( (LA39_1==39) ) {
                    alt39=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalContract.g:1506:3: this_SingleValDeclaration_0= ruleSingleValDeclaration
                    {

                    			newCompositeNode(grammarAccess.getQueryAccess().getSingleValDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SingleValDeclaration_0=ruleSingleValDeclaration();

                    state._fsp--;


                    			current = this_SingleValDeclaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalContract.g:1515:3: ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) )
                    {
                    // InternalContract.g:1515:3: ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) )
                    // InternalContract.g:1516:4: () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) )
                    {
                    // InternalContract.g:1516:4: ()
                    // InternalContract.g:1517:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getQueryAccess().getTupleDeclarationAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,47,FOLLOW_35); 

                    				newLeafNode(otherlv_2, grammarAccess.getQueryAccess().getValKeyword_1_1());
                    			
                    otherlv_3=(Token)match(input,39,FOLLOW_4); 

                    				newLeafNode(otherlv_3, grammarAccess.getQueryAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalContract.g:1531:4: ( (lv_names_4_0= ruleTupleName ) )
                    // InternalContract.g:1532:5: (lv_names_4_0= ruleTupleName )
                    {
                    // InternalContract.g:1532:5: (lv_names_4_0= ruleTupleName )
                    // InternalContract.g:1533:6: lv_names_4_0= ruleTupleName
                    {

                    						newCompositeNode(grammarAccess.getQueryAccess().getNamesTupleNameParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_names_4_0=ruleTupleName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getQueryRule());
                    						}
                    						add(
                    							current,
                    							"names",
                    							lv_names_4_0,
                    							"org.osate.contract.Contract.TupleName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:1550:4: (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==48) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalContract.g:1551:5: otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) )
                    	    {
                    	    otherlv_5=(Token)match(input,48,FOLLOW_4); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getQueryAccess().getCommaKeyword_1_4_0());
                    	    				
                    	    // InternalContract.g:1555:5: ( (lv_names_6_0= ruleTupleName ) )
                    	    // InternalContract.g:1556:6: (lv_names_6_0= ruleTupleName )
                    	    {
                    	    // InternalContract.g:1556:6: (lv_names_6_0= ruleTupleName )
                    	    // InternalContract.g:1557:7: lv_names_6_0= ruleTupleName
                    	    {

                    	    							newCompositeNode(grammarAccess.getQueryAccess().getNamesTupleNameParserRuleCall_1_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_47);
                    	    lv_names_6_0=ruleTupleName();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getQueryRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"names",
                    	    								lv_names_6_0,
                    	    								"org.osate.contract.Contract.TupleName");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt38 >= 1 ) break loop38;
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);

                    otherlv_7=(Token)match(input,40,FOLLOW_48); 

                    				newLeafNode(otherlv_7, grammarAccess.getQueryAccess().getRightParenthesisKeyword_1_5());
                    			
                    otherlv_8=(Token)match(input,49,FOLLOW_49); 

                    				newLeafNode(otherlv_8, grammarAccess.getQueryAccess().getEqualsSignKeyword_1_6());
                    			
                    // InternalContract.g:1583:4: ( (lv_value_9_0= ruleExpression ) )
                    // InternalContract.g:1584:5: (lv_value_9_0= ruleExpression )
                    {
                    // InternalContract.g:1584:5: (lv_value_9_0= ruleExpression )
                    // InternalContract.g:1585:6: lv_value_9_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getQueryAccess().getValueExpressionParserRuleCall_1_7_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_9_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getQueryRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_9_0,
                    							"org.osate.contract.Contract.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuery"


    // $ANTLR start "entryRuleSingleValDeclaration"
    // InternalContract.g:1607:1: entryRuleSingleValDeclaration returns [EObject current=null] : iv_ruleSingleValDeclaration= ruleSingleValDeclaration EOF ;
    public final EObject entryRuleSingleValDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValDeclaration = null;


        try {
            // InternalContract.g:1607:61: (iv_ruleSingleValDeclaration= ruleSingleValDeclaration EOF )
            // InternalContract.g:1608:2: iv_ruleSingleValDeclaration= ruleSingleValDeclaration EOF
            {
             newCompositeNode(grammarAccess.getSingleValDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleValDeclaration=ruleSingleValDeclaration();

            state._fsp--;

             current =iv_ruleSingleValDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleValDeclaration"


    // $ANTLR start "ruleSingleValDeclaration"
    // InternalContract.g:1614:1: ruleSingleValDeclaration returns [EObject current=null] : (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleSingleValDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1620:2: ( (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalContract.g:1621:2: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalContract.g:1621:2: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleExpression ) ) )
            // InternalContract.g:1622:3: otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getSingleValDeclarationAccess().getValKeyword_0());
            		
            // InternalContract.g:1626:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:1627:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:1627:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:1628:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_48); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSingleValDeclarationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingleValDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.osate.xtext.aadl2.properties.Properties.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,49,FOLLOW_49); 

            			newLeafNode(otherlv_2, grammarAccess.getSingleValDeclarationAccess().getEqualsSignKeyword_2());
            		
            // InternalContract.g:1648:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalContract.g:1649:4: (lv_value_3_0= ruleExpression )
            {
            // InternalContract.g:1649:4: (lv_value_3_0= ruleExpression )
            // InternalContract.g:1650:5: lv_value_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getSingleValDeclarationAccess().getValueExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSingleValDeclarationRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.osate.contract.Contract.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleValDeclaration"


    // $ANTLR start "entryRuleTupleName"
    // InternalContract.g:1671:1: entryRuleTupleName returns [EObject current=null] : iv_ruleTupleName= ruleTupleName EOF ;
    public final EObject entryRuleTupleName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleName = null;


        try {
            // InternalContract.g:1671:50: (iv_ruleTupleName= ruleTupleName EOF )
            // InternalContract.g:1672:2: iv_ruleTupleName= ruleTupleName EOF
            {
             newCompositeNode(grammarAccess.getTupleNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTupleName=ruleTupleName();

            state._fsp--;

             current =iv_ruleTupleName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleName"


    // $ANTLR start "ruleTupleName"
    // InternalContract.g:1678:1: ruleTupleName returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleTupleName() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:1684:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalContract.g:1685:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalContract.g:1685:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalContract.g:1686:3: (lv_name_0_0= RULE_ID )
            {
            // InternalContract.g:1686:3: (lv_name_0_0= RULE_ID )
            // InternalContract.g:1687:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getTupleNameAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getTupleNameRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.osate.xtext.aadl2.properties.Properties.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleName"


    // $ANTLR start "entryRuleExpression"
    // InternalContract.g:1706:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalContract.g:1706:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalContract.g:1707:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalContract.g:1713:1: ruleExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1719:2: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalContract.g:1720:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalContract.g:1720:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalContract.g:1721:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_50);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;


            			current = this_AndExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalContract.g:1729:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==50) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalContract.g:1730:4: () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalContract.g:1730:4: ()
            	    // InternalContract.g:1731:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getExpressionAccess().getOrExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,50,FOLLOW_49); 

            	    				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	    			
            	    // InternalContract.g:1741:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalContract.g:1742:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalContract.g:1742:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalContract.g:1743:6: lv_right_3_0= ruleAndExpression
            	    {

            	    						newCompositeNode(grammarAccess.getExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_50);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.osate.contract.Contract.AndExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalContract.g:1765:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalContract.g:1765:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalContract.g:1766:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalContract.g:1772:1: ruleAndExpression returns [EObject current=null] : (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_NotExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1778:2: ( (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* ) )
            // InternalContract.g:1779:2: (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* )
            {
            // InternalContract.g:1779:2: (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* )
            // InternalContract.g:1780:3: this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndExpressionAccess().getNotExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_51);
            this_NotExpression_0=ruleNotExpression();

            state._fsp--;


            			current = this_NotExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalContract.g:1788:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==51) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalContract.g:1789:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) )
            	    {
            	    // InternalContract.g:1789:4: ()
            	    // InternalContract.g:1790:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,51,FOLLOW_49); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	    			
            	    // InternalContract.g:1800:4: ( (lv_right_3_0= ruleNotExpression ) )
            	    // InternalContract.g:1801:5: (lv_right_3_0= ruleNotExpression )
            	    {
            	    // InternalContract.g:1801:5: (lv_right_3_0= ruleNotExpression )
            	    // InternalContract.g:1802:6: lv_right_3_0= ruleNotExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_51);
            	    lv_right_3_0=ruleNotExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.osate.contract.Contract.NotExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleNotExpression"
    // InternalContract.g:1824:1: entryRuleNotExpression returns [EObject current=null] : iv_ruleNotExpression= ruleNotExpression EOF ;
    public final EObject entryRuleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpression = null;


        try {
            // InternalContract.g:1824:54: (iv_ruleNotExpression= ruleNotExpression EOF )
            // InternalContract.g:1825:2: iv_ruleNotExpression= ruleNotExpression EOF
            {
             newCompositeNode(grammarAccess.getNotExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotExpression=ruleNotExpression();

            state._fsp--;

             current =iv_ruleNotExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotExpression"


    // $ANTLR start "ruleNotExpression"
    // InternalContract.g:1831:1: ruleNotExpression returns [EObject current=null] : (this_CallExpression_0= ruleCallExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) ) ) ;
    public final EObject ruleNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_CallExpression_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1837:2: ( (this_CallExpression_0= ruleCallExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) ) ) )
            // InternalContract.g:1838:2: (this_CallExpression_0= ruleCallExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) ) )
            {
            // InternalContract.g:1838:2: (this_CallExpression_0= ruleCallExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID||LA42_0==39||(LA42_0>=56 && LA42_0<=57)) ) {
                alt42=1;
            }
            else if ( (LA42_0==52) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalContract.g:1839:3: this_CallExpression_0= ruleCallExpression
                    {

                    			newCompositeNode(grammarAccess.getNotExpressionAccess().getCallExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_CallExpression_0=ruleCallExpression();

                    state._fsp--;


                    			current = this_CallExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalContract.g:1848:3: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) )
                    {
                    // InternalContract.g:1848:3: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) )
                    // InternalContract.g:1849:4: () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) )
                    {
                    // InternalContract.g:1849:4: ()
                    // InternalContract.g:1850:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getNotExpressionAccess().getNotExpressionAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,52,FOLLOW_52); 

                    				newLeafNode(otherlv_2, grammarAccess.getNotExpressionAccess().getExclamationMarkKeyword_1_1());
                    			
                    // InternalContract.g:1860:4: ( (lv_operand_3_0= ruleCallExpression ) )
                    // InternalContract.g:1861:5: (lv_operand_3_0= ruleCallExpression )
                    {
                    // InternalContract.g:1861:5: (lv_operand_3_0= ruleCallExpression )
                    // InternalContract.g:1862:6: lv_operand_3_0= ruleCallExpression
                    {

                    						newCompositeNode(grammarAccess.getNotExpressionAccess().getOperandCallExpressionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operand_3_0=ruleCallExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNotExpressionRule());
                    						}
                    						set(
                    							current,
                    							"operand",
                    							lv_operand_3_0,
                    							"org.osate.contract.Contract.CallExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotExpression"


    // $ANTLR start "entryRuleCallExpression"
    // InternalContract.g:1884:1: entryRuleCallExpression returns [EObject current=null] : iv_ruleCallExpression= ruleCallExpression EOF ;
    public final EObject entryRuleCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExpression = null;


        try {
            // InternalContract.g:1884:55: (iv_ruleCallExpression= ruleCallExpression EOF )
            // InternalContract.g:1885:2: iv_ruleCallExpression= ruleCallExpression EOF
            {
             newCompositeNode(grammarAccess.getCallExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCallExpression=ruleCallExpression();

            state._fsp--;

             current =iv_ruleCallExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallExpression"


    // $ANTLR start "ruleCallExpression"
    // InternalContract.g:1891:1: ruleCallExpression returns [EObject current=null] : (this_TerminalExpression_0= ruleTerminalExpression ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')' )? ( (lv_lambda_7_0= ruleLambda ) )? ) | ( () otherlv_9= '#' ( ( ruleQPREF ) ) ) )* ) ;
    public final EObject ruleCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_right_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject this_TerminalExpression_0 = null;

        EObject lv_argument_5_0 = null;

        EObject lv_lambda_7_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1897:2: ( (this_TerminalExpression_0= ruleTerminalExpression ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')' )? ( (lv_lambda_7_0= ruleLambda ) )? ) | ( () otherlv_9= '#' ( ( ruleQPREF ) ) ) )* ) )
            // InternalContract.g:1898:2: (this_TerminalExpression_0= ruleTerminalExpression ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')' )? ( (lv_lambda_7_0= ruleLambda ) )? ) | ( () otherlv_9= '#' ( ( ruleQPREF ) ) ) )* )
            {
            // InternalContract.g:1898:2: (this_TerminalExpression_0= ruleTerminalExpression ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')' )? ( (lv_lambda_7_0= ruleLambda ) )? ) | ( () otherlv_9= '#' ( ( ruleQPREF ) ) ) )* )
            // InternalContract.g:1899:3: this_TerminalExpression_0= ruleTerminalExpression ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')' )? ( (lv_lambda_7_0= ruleLambda ) )? ) | ( () otherlv_9= '#' ( ( ruleQPREF ) ) ) )*
            {

            			newCompositeNode(grammarAccess.getCallExpressionAccess().getTerminalExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_53);
            this_TerminalExpression_0=ruleTerminalExpression();

            state._fsp--;


            			current = this_TerminalExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalContract.g:1907:3: ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')' )? ( (lv_lambda_7_0= ruleLambda ) )? ) | ( () otherlv_9= '#' ( ( ruleQPREF ) ) ) )*
            loop45:
            do {
                int alt45=3;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==53) ) {
                    alt45=1;
                }
                else if ( (LA45_0==54) ) {
                    alt45=2;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalContract.g:1908:4: ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')' )? ( (lv_lambda_7_0= ruleLambda ) )? )
            	    {
            	    // InternalContract.g:1908:4: ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')' )? ( (lv_lambda_7_0= ruleLambda ) )? )
            	    // InternalContract.g:1909:5: () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')' )? ( (lv_lambda_7_0= ruleLambda ) )?
            	    {
            	    // InternalContract.g:1909:5: ()
            	    // InternalContract.g:1910:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getCallExpressionAccess().getMemberCallLeftAction_1_0_0(),
            	    							current);
            	    					

            	    }

            	    otherlv_2=(Token)match(input,53,FOLLOW_4); 

            	    					newLeafNode(otherlv_2, grammarAccess.getCallExpressionAccess().getFullStopKeyword_1_0_1());
            	    				
            	    // InternalContract.g:1920:5: ( (lv_right_3_0= RULE_ID ) )
            	    // InternalContract.g:1921:6: (lv_right_3_0= RULE_ID )
            	    {
            	    // InternalContract.g:1921:6: (lv_right_3_0= RULE_ID )
            	    // InternalContract.g:1922:7: lv_right_3_0= RULE_ID
            	    {
            	    lv_right_3_0=(Token)match(input,RULE_ID,FOLLOW_54); 

            	    							newLeafNode(lv_right_3_0, grammarAccess.getCallExpressionAccess().getRightIDTerminalRuleCall_1_0_2_0());
            	    						

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getCallExpressionRule());
            	    							}
            	    							setWithLastConsumed(
            	    								current,
            	    								"right",
            	    								lv_right_3_0,
            	    								"org.osate.xtext.aadl2.properties.Properties.ID");
            	    						

            	    }


            	    }

            	    // InternalContract.g:1938:5: (otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')' )?
            	    int alt43=2;
            	    int LA43_0 = input.LA(1);

            	    if ( (LA43_0==39) ) {
            	        alt43=1;
            	    }
            	    switch (alt43) {
            	        case 1 :
            	            // InternalContract.g:1939:6: otherlv_4= '(' ( (lv_argument_5_0= ruleExpression ) ) otherlv_6= ')'
            	            {
            	            otherlv_4=(Token)match(input,39,FOLLOW_49); 

            	            						newLeafNode(otherlv_4, grammarAccess.getCallExpressionAccess().getLeftParenthesisKeyword_1_0_3_0());
            	            					
            	            // InternalContract.g:1943:6: ( (lv_argument_5_0= ruleExpression ) )
            	            // InternalContract.g:1944:7: (lv_argument_5_0= ruleExpression )
            	            {
            	            // InternalContract.g:1944:7: (lv_argument_5_0= ruleExpression )
            	            // InternalContract.g:1945:8: lv_argument_5_0= ruleExpression
            	            {

            	            								newCompositeNode(grammarAccess.getCallExpressionAccess().getArgumentExpressionParserRuleCall_1_0_3_1_0());
            	            							
            	            pushFollow(FOLLOW_55);
            	            lv_argument_5_0=ruleExpression();

            	            state._fsp--;


            	            								if (current==null) {
            	            									current = createModelElementForParent(grammarAccess.getCallExpressionRule());
            	            								}
            	            								set(
            	            									current,
            	            									"argument",
            	            									lv_argument_5_0,
            	            									"org.osate.contract.Contract.Expression");
            	            								afterParserOrEnumRuleCall();
            	            							

            	            }


            	            }

            	            otherlv_6=(Token)match(input,40,FOLLOW_56); 

            	            						newLeafNode(otherlv_6, grammarAccess.getCallExpressionAccess().getRightParenthesisKeyword_1_0_3_2());
            	            					

            	            }
            	            break;

            	    }

            	    // InternalContract.g:1967:5: ( (lv_lambda_7_0= ruleLambda ) )?
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==22) ) {
            	        alt44=1;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // InternalContract.g:1968:6: (lv_lambda_7_0= ruleLambda )
            	            {
            	            // InternalContract.g:1968:6: (lv_lambda_7_0= ruleLambda )
            	            // InternalContract.g:1969:7: lv_lambda_7_0= ruleLambda
            	            {

            	            							newCompositeNode(grammarAccess.getCallExpressionAccess().getLambdaLambdaParserRuleCall_1_0_4_0());
            	            						
            	            pushFollow(FOLLOW_53);
            	            lv_lambda_7_0=ruleLambda();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getCallExpressionRule());
            	            							}
            	            							set(
            	            								current,
            	            								"lambda",
            	            								lv_lambda_7_0,
            	            								"org.osate.contract.Contract.Lambda");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalContract.g:1988:4: ( () otherlv_9= '#' ( ( ruleQPREF ) ) )
            	    {
            	    // InternalContract.g:1988:4: ( () otherlv_9= '#' ( ( ruleQPREF ) ) )
            	    // InternalContract.g:1989:5: () otherlv_9= '#' ( ( ruleQPREF ) )
            	    {
            	    // InternalContract.g:1989:5: ()
            	    // InternalContract.g:1990:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getCallExpressionAccess().getPropertyLookupLeftAction_1_1_0(),
            	    							current);
            	    					

            	    }

            	    otherlv_9=(Token)match(input,54,FOLLOW_4); 

            	    					newLeafNode(otherlv_9, grammarAccess.getCallExpressionAccess().getNumberSignKeyword_1_1_1());
            	    				
            	    // InternalContract.g:2000:5: ( ( ruleQPREF ) )
            	    // InternalContract.g:2001:6: ( ruleQPREF )
            	    {
            	    // InternalContract.g:2001:6: ( ruleQPREF )
            	    // InternalContract.g:2002:7: ruleQPREF
            	    {

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getCallExpressionRule());
            	    							}
            	    						

            	    							newCompositeNode(grammarAccess.getCallExpressionAccess().getRightPropertyCrossReference_1_1_2_0());
            	    						
            	    pushFollow(FOLLOW_53);
            	    ruleQPREF();

            	    state._fsp--;


            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallExpression"


    // $ANTLR start "entryRuleLambda"
    // InternalContract.g:2022:1: entryRuleLambda returns [EObject current=null] : iv_ruleLambda= ruleLambda EOF ;
    public final EObject entryRuleLambda() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambda = null;


        try {
            // InternalContract.g:2022:47: (iv_ruleLambda= ruleLambda EOF )
            // InternalContract.g:2023:2: iv_ruleLambda= ruleLambda EOF
            {
             newCompositeNode(grammarAccess.getLambdaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLambda=ruleLambda();

            state._fsp--;

             current =iv_ruleLambda; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLambda"


    // $ANTLR start "ruleLambda"
    // InternalContract.g:2029:1: ruleLambda returns [EObject current=null] : (otherlv_0= '{' ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '->' this_Queries_3= ruleQueries[$current] ( (lv_returnValue_4_0= ruleExpression ) ) otherlv_5= '}' ) ;
    public final EObject ruleLambda() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_parameter_1_0 = null;

        EObject this_Queries_3 = null;

        EObject lv_returnValue_4_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2035:2: ( (otherlv_0= '{' ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '->' this_Queries_3= ruleQueries[$current] ( (lv_returnValue_4_0= ruleExpression ) ) otherlv_5= '}' ) )
            // InternalContract.g:2036:2: (otherlv_0= '{' ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '->' this_Queries_3= ruleQueries[$current] ( (lv_returnValue_4_0= ruleExpression ) ) otherlv_5= '}' )
            {
            // InternalContract.g:2036:2: (otherlv_0= '{' ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '->' this_Queries_3= ruleQueries[$current] ( (lv_returnValue_4_0= ruleExpression ) ) otherlv_5= '}' )
            // InternalContract.g:2037:3: otherlv_0= '{' ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '->' this_Queries_3= ruleQueries[$current] ( (lv_returnValue_4_0= ruleExpression ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_57); 

            			newLeafNode(otherlv_0, grammarAccess.getLambdaAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalContract.g:2041:3: ( (lv_parameter_1_0= ruleParameter ) )
            // InternalContract.g:2042:4: (lv_parameter_1_0= ruleParameter )
            {
            // InternalContract.g:2042:4: (lv_parameter_1_0= ruleParameter )
            // InternalContract.g:2043:5: lv_parameter_1_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getLambdaAccess().getParameterParameterParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_58);
            lv_parameter_1_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLambdaRule());
            					}
            					set(
            						current,
            						"parameter",
            						lv_parameter_1_0,
            						"org.osate.contract.Contract.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,55,FOLLOW_59); 

            			newLeafNode(otherlv_2, grammarAccess.getLambdaAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		

            			if (current==null) {
            				current = createModelElement(grammarAccess.getLambdaRule());
            			}
            			newCompositeNode(grammarAccess.getLambdaAccess().getQueriesParserRuleCall_3());
            		
            pushFollow(FOLLOW_49);
            this_Queries_3=ruleQueries(current);

            state._fsp--;


            			current = this_Queries_3;
            			afterParserOrEnumRuleCall();
            		
            // InternalContract.g:2075:3: ( (lv_returnValue_4_0= ruleExpression ) )
            // InternalContract.g:2076:4: (lv_returnValue_4_0= ruleExpression )
            {
            // InternalContract.g:2076:4: (lv_returnValue_4_0= ruleExpression )
            // InternalContract.g:2077:5: lv_returnValue_4_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getLambdaAccess().getReturnValueExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_20);
            lv_returnValue_4_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLambdaRule());
            					}
            					set(
            						current,
            						"returnValue",
            						lv_returnValue_4_0,
            						"org.osate.contract.Contract.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,31,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getLambdaAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLambda"


    // $ANTLR start "entryRuleParameter"
    // InternalContract.g:2102:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalContract.g:2102:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalContract.g:2103:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalContract.g:2109:1: ruleParameter returns [EObject current=null] : (this_SingleParameter_0= ruleSingleParameter | ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_SingleParameter_0 = null;

        EObject lv_names_3_0 = null;

        EObject lv_names_5_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2115:2: ( (this_SingleParameter_0= ruleSingleParameter | ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' ) ) )
            // InternalContract.g:2116:2: (this_SingleParameter_0= ruleSingleParameter | ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' ) )
            {
            // InternalContract.g:2116:2: (this_SingleParameter_0= ruleSingleParameter | ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID) ) {
                alt47=1;
            }
            else if ( (LA47_0==39) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalContract.g:2117:3: this_SingleParameter_0= ruleSingleParameter
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getSingleParameterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SingleParameter_0=ruleSingleParameter();

                    state._fsp--;


                    			current = this_SingleParameter_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalContract.g:2126:3: ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' )
                    {
                    // InternalContract.g:2126:3: ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' )
                    // InternalContract.g:2127:4: () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')'
                    {
                    // InternalContract.g:2127:4: ()
                    // InternalContract.g:2128:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getParameterAccess().getTupleParameterAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,39,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalContract.g:2138:4: ( (lv_names_3_0= ruleTupleName ) )
                    // InternalContract.g:2139:5: (lv_names_3_0= ruleTupleName )
                    {
                    // InternalContract.g:2139:5: (lv_names_3_0= ruleTupleName )
                    // InternalContract.g:2140:6: lv_names_3_0= ruleTupleName
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getNamesTupleNameParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_names_3_0=ruleTupleName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						add(
                    							current,
                    							"names",
                    							lv_names_3_0,
                    							"org.osate.contract.Contract.TupleName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:2157:4: (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+
                    int cnt46=0;
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==48) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalContract.g:2158:5: otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,48,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getCommaKeyword_1_3_0());
                    	    				
                    	    // InternalContract.g:2162:5: ( (lv_names_5_0= ruleTupleName ) )
                    	    // InternalContract.g:2163:6: (lv_names_5_0= ruleTupleName )
                    	    {
                    	    // InternalContract.g:2163:6: (lv_names_5_0= ruleTupleName )
                    	    // InternalContract.g:2164:7: lv_names_5_0= ruleTupleName
                    	    {

                    	    							newCompositeNode(grammarAccess.getParameterAccess().getNamesTupleNameParserRuleCall_1_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_47);
                    	    lv_names_5_0=ruleTupleName();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getParameterRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"names",
                    	    								lv_names_5_0,
                    	    								"org.osate.contract.Contract.TupleName");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt46 >= 1 ) break loop46;
                                EarlyExitException eee =
                                    new EarlyExitException(46, input);
                                throw eee;
                        }
                        cnt46++;
                    } while (true);

                    otherlv_6=(Token)match(input,40,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getRightParenthesisKeyword_1_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleSingleParameter"
    // InternalContract.g:2191:1: entryRuleSingleParameter returns [EObject current=null] : iv_ruleSingleParameter= ruleSingleParameter EOF ;
    public final EObject entryRuleSingleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleParameter = null;


        try {
            // InternalContract.g:2191:56: (iv_ruleSingleParameter= ruleSingleParameter EOF )
            // InternalContract.g:2192:2: iv_ruleSingleParameter= ruleSingleParameter EOF
            {
             newCompositeNode(grammarAccess.getSingleParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleParameter=ruleSingleParameter();

            state._fsp--;

             current =iv_ruleSingleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleParameter"


    // $ANTLR start "ruleSingleParameter"
    // InternalContract.g:2198:1: ruleSingleParameter returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleSingleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:2204:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalContract.g:2205:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalContract.g:2205:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalContract.g:2206:3: (lv_name_0_0= RULE_ID )
            {
            // InternalContract.g:2206:3: (lv_name_0_0= RULE_ID )
            // InternalContract.g:2207:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getSingleParameterAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getSingleParameterRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.osate.xtext.aadl2.properties.Properties.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleParameter"


    // $ANTLR start "entryRuleTerminalExpression"
    // InternalContract.g:2226:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // InternalContract.g:2226:59: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // InternalContract.g:2227:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
            {
             newCompositeNode(grammarAccess.getTerminalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminalExpression=ruleTerminalExpression();

            state._fsp--;

             current =iv_ruleTerminalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // InternalContract.g:2233:1: ruleTerminalExpression returns [EObject current=null] : ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'root' ) | ( () ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= '(' this_Expression_7= ruleExpression ( () (otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) ) )+ )? otherlv_11= ')' ) ) ;
    public final EObject ruleTerminalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject this_Expression_7 = null;

        EObject lv_elements_10_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2239:2: ( ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'root' ) | ( () ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= '(' this_Expression_7= ruleExpression ( () (otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) ) )+ )? otherlv_11= ')' ) ) )
            // InternalContract.g:2240:2: ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'root' ) | ( () ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= '(' this_Expression_7= ruleExpression ( () (otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) ) )+ )? otherlv_11= ')' ) )
            {
            // InternalContract.g:2240:2: ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'root' ) | ( () ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= '(' this_Expression_7= ruleExpression ( () (otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) ) )+ )? otherlv_11= ')' ) )
            int alt50=4;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt50=1;
                }
                break;
            case 57:
                {
                alt50=2;
                }
                break;
            case RULE_ID:
                {
                alt50=3;
                }
                break;
            case 39:
                {
                alt50=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalContract.g:2241:3: ( () otherlv_1= 'self' )
                    {
                    // InternalContract.g:2241:3: ( () otherlv_1= 'self' )
                    // InternalContract.g:2242:4: () otherlv_1= 'self'
                    {
                    // InternalContract.g:2242:4: ()
                    // InternalContract.g:2243:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getSelfExpressionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,56,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getTerminalExpressionAccess().getSelfKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:2255:3: ( () otherlv_3= 'root' )
                    {
                    // InternalContract.g:2255:3: ( () otherlv_3= 'root' )
                    // InternalContract.g:2256:4: () otherlv_3= 'root'
                    {
                    // InternalContract.g:2256:4: ()
                    // InternalContract.g:2257:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getRootExpressionAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,57,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getTerminalExpressionAccess().getRootKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalContract.g:2269:3: ( () ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalContract.g:2269:3: ( () ( (otherlv_5= RULE_ID ) ) )
                    // InternalContract.g:2270:4: () ( (otherlv_5= RULE_ID ) )
                    {
                    // InternalContract.g:2270:4: ()
                    // InternalContract.g:2271:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getNameReferenceAction_2_0(),
                    						current);
                    				

                    }

                    // InternalContract.g:2277:4: ( (otherlv_5= RULE_ID ) )
                    // InternalContract.g:2278:5: (otherlv_5= RULE_ID )
                    {
                    // InternalContract.g:2278:5: (otherlv_5= RULE_ID )
                    // InternalContract.g:2279:6: otherlv_5= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTerminalExpressionRule());
                    						}
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_5, grammarAccess.getTerminalExpressionAccess().getReferenceNamedElementCrossReference_2_1_0());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalContract.g:2292:3: (otherlv_6= '(' this_Expression_7= ruleExpression ( () (otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) ) )+ )? otherlv_11= ')' )
                    {
                    // InternalContract.g:2292:3: (otherlv_6= '(' this_Expression_7= ruleExpression ( () (otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) ) )+ )? otherlv_11= ')' )
                    // InternalContract.g:2293:4: otherlv_6= '(' this_Expression_7= ruleExpression ( () (otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) ) )+ )? otherlv_11= ')'
                    {
                    otherlv_6=(Token)match(input,39,FOLLOW_49); 

                    				newLeafNode(otherlv_6, grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_3_0());
                    			

                    				newCompositeNode(grammarAccess.getTerminalExpressionAccess().getExpressionParserRuleCall_3_1());
                    			
                    pushFollow(FOLLOW_47);
                    this_Expression_7=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_7;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalContract.g:2305:4: ( () (otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) ) )+ )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==48) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalContract.g:2306:5: () (otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) ) )+
                            {
                            // InternalContract.g:2306:5: ()
                            // InternalContract.g:2307:6: 
                            {

                            						current = forceCreateModelElementAndAdd(
                            							grammarAccess.getTerminalExpressionAccess().getTupleExpressionElementsAction_3_2_0(),
                            							current);
                            					

                            }

                            // InternalContract.g:2313:5: (otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) ) )+
                            int cnt48=0;
                            loop48:
                            do {
                                int alt48=2;
                                int LA48_0 = input.LA(1);

                                if ( (LA48_0==48) ) {
                                    alt48=1;
                                }


                                switch (alt48) {
                            	case 1 :
                            	    // InternalContract.g:2314:6: otherlv_9= ',' ( (lv_elements_10_0= ruleExpression ) )
                            	    {
                            	    otherlv_9=(Token)match(input,48,FOLLOW_49); 

                            	    						newLeafNode(otherlv_9, grammarAccess.getTerminalExpressionAccess().getCommaKeyword_3_2_1_0());
                            	    					
                            	    // InternalContract.g:2318:6: ( (lv_elements_10_0= ruleExpression ) )
                            	    // InternalContract.g:2319:7: (lv_elements_10_0= ruleExpression )
                            	    {
                            	    // InternalContract.g:2319:7: (lv_elements_10_0= ruleExpression )
                            	    // InternalContract.g:2320:8: lv_elements_10_0= ruleExpression
                            	    {

                            	    								newCompositeNode(grammarAccess.getTerminalExpressionAccess().getElementsExpressionParserRuleCall_3_2_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_47);
                            	    lv_elements_10_0=ruleExpression();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getTerminalExpressionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"elements",
                            	    									lv_elements_10_0,
                            	    									"org.osate.contract.Contract.Expression");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt48 >= 1 ) break loop48;
                                        EarlyExitException eee =
                                            new EarlyExitException(48, input);
                                        throw eee;
                                }
                                cnt48++;
                            } while (true);


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,40,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getTerminalExpressionAccess().getRightParenthesisKeyword_3_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "entryRuleContractSubclause"
    // InternalContract.g:2348:1: entryRuleContractSubclause returns [EObject current=null] : iv_ruleContractSubclause= ruleContractSubclause EOF ;
    public final EObject entryRuleContractSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractSubclause = null;


        try {
            // InternalContract.g:2348:58: (iv_ruleContractSubclause= ruleContractSubclause EOF )
            // InternalContract.g:2349:2: iv_ruleContractSubclause= ruleContractSubclause EOF
            {
             newCompositeNode(grammarAccess.getContractSubclauseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractSubclause=ruleContractSubclause();

            state._fsp--;

             current =iv_ruleContractSubclause; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractSubclause"


    // $ANTLR start "ruleContractSubclause"
    // InternalContract.g:2355:1: ruleContractSubclause returns [EObject current=null] : ( () (otherlv_1= 'use' ( ( ruleQPREF ) ) )* (otherlv_3= 'verify' ( ( ruleQPREF ) ) otherlv_5= ';' )* ) ;
    public final EObject ruleContractSubclause() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalContract.g:2361:2: ( ( () (otherlv_1= 'use' ( ( ruleQPREF ) ) )* (otherlv_3= 'verify' ( ( ruleQPREF ) ) otherlv_5= ';' )* ) )
            // InternalContract.g:2362:2: ( () (otherlv_1= 'use' ( ( ruleQPREF ) ) )* (otherlv_3= 'verify' ( ( ruleQPREF ) ) otherlv_5= ';' )* )
            {
            // InternalContract.g:2362:2: ( () (otherlv_1= 'use' ( ( ruleQPREF ) ) )* (otherlv_3= 'verify' ( ( ruleQPREF ) ) otherlv_5= ';' )* )
            // InternalContract.g:2363:3: () (otherlv_1= 'use' ( ( ruleQPREF ) ) )* (otherlv_3= 'verify' ( ( ruleQPREF ) ) otherlv_5= ';' )*
            {
            // InternalContract.g:2363:3: ()
            // InternalContract.g:2364:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContractSubclauseAccess().getContractSubclauseAction_0(),
            					current);
            			

            }

            // InternalContract.g:2370:3: (otherlv_1= 'use' ( ( ruleQPREF ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==58) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalContract.g:2371:4: otherlv_1= 'use' ( ( ruleQPREF ) )
            	    {
            	    otherlv_1=(Token)match(input,58,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getContractSubclauseAccess().getUseKeyword_1_0());
            	    			
            	    // InternalContract.g:2375:4: ( ( ruleQPREF ) )
            	    // InternalContract.g:2376:5: ( ruleQPREF )
            	    {
            	    // InternalContract.g:2376:5: ( ruleQPREF )
            	    // InternalContract.g:2377:6: ruleQPREF
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getContractSubclauseRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getContractSubclauseAccess().getUseQueriesContractCrossReference_1_1_0());
            	    					
            	    pushFollow(FOLLOW_60);
            	    ruleQPREF();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            // InternalContract.g:2392:3: (otherlv_3= 'verify' ( ( ruleQPREF ) ) otherlv_5= ';' )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==59) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalContract.g:2393:4: otherlv_3= 'verify' ( ( ruleQPREF ) ) otherlv_5= ';'
            	    {
            	    otherlv_3=(Token)match(input,59,FOLLOW_4); 

            	    				newLeafNode(otherlv_3, grammarAccess.getContractSubclauseAccess().getVerifyKeyword_2_0());
            	    			
            	    // InternalContract.g:2397:4: ( ( ruleQPREF ) )
            	    // InternalContract.g:2398:5: ( ruleQPREF )
            	    {
            	    // InternalContract.g:2398:5: ( ruleQPREF )
            	    // InternalContract.g:2399:6: ruleQPREF
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getContractSubclauseRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getContractSubclauseAccess().getVerifyPlansVerificationPlanCrossReference_2_1_0());
            	    					
            	    pushFollow(FOLLOW_17);
            	    ruleQPREF();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_5=(Token)match(input,28,FOLLOW_61); 

            	    				newLeafNode(otherlv_5, grammarAccess.getContractSubclauseAccess().getSemicolonKeyword_2_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractSubclause"


    // $ANTLR start "entryRuleIString"
    // InternalContract.g:2422:1: entryRuleIString returns [EObject current=null] : iv_ruleIString= ruleIString EOF ;
    public final EObject entryRuleIString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIString = null;


        try {
            // InternalContract.g:2422:48: (iv_ruleIString= ruleIString EOF )
            // InternalContract.g:2423:2: iv_ruleIString= ruleIString EOF
            {
             newCompositeNode(grammarAccess.getIStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIString=ruleIString();

            state._fsp--;

             current =iv_ruleIString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIString"


    // $ANTLR start "ruleIString"
    // InternalContract.g:2429:1: ruleIString returns [EObject current=null] : ( ( (lv_parts_0_0= ruleIStringLiteral ) ) | ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) ) ) ;
    public final EObject ruleIString() throws RecognitionException {
        EObject current = null;

        EObject lv_parts_0_0 = null;

        EObject lv_parts_1_0 = null;

        EObject lv_parts_2_0 = null;

        EObject lv_parts_3_0 = null;

        EObject lv_parts_4_0 = null;

        EObject lv_parts_5_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2435:2: ( ( ( (lv_parts_0_0= ruleIStringLiteral ) ) | ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) ) ) )
            // InternalContract.g:2436:2: ( ( (lv_parts_0_0= ruleIStringLiteral ) ) | ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) ) )
            {
            // InternalContract.g:2436:2: ( ( (lv_parts_0_0= ruleIStringLiteral ) ) | ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ISTRING_TEXT) ) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_ISTRING_LEFT) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalContract.g:2437:3: ( (lv_parts_0_0= ruleIStringLiteral ) )
                    {
                    // InternalContract.g:2437:3: ( (lv_parts_0_0= ruleIStringLiteral ) )
                    // InternalContract.g:2438:4: (lv_parts_0_0= ruleIStringLiteral )
                    {
                    // InternalContract.g:2438:4: (lv_parts_0_0= ruleIStringLiteral )
                    // InternalContract.g:2439:5: lv_parts_0_0= ruleIStringLiteral
                    {

                    					newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringLiteralParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_parts_0_0=ruleIStringLiteral();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIStringRule());
                    					}
                    					add(
                    						current,
                    						"parts",
                    						lv_parts_0_0,
                    						"org.osate.contract.Contract.IStringLiteral");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:2457:3: ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) )
                    {
                    // InternalContract.g:2457:3: ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) )
                    // InternalContract.g:2458:4: ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) )
                    {
                    // InternalContract.g:2458:4: ( (lv_parts_1_0= ruleIStringLeftLiteral ) )
                    // InternalContract.g:2459:5: (lv_parts_1_0= ruleIStringLeftLiteral )
                    {
                    // InternalContract.g:2459:5: (lv_parts_1_0= ruleIStringLeftLiteral )
                    // InternalContract.g:2460:6: lv_parts_1_0= ruleIStringLeftLiteral
                    {

                    						newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringLeftLiteralParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_62);
                    lv_parts_1_0=ruleIStringLeftLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIStringRule());
                    						}
                    						add(
                    							current,
                    							"parts",
                    							lv_parts_1_0,
                    							"org.osate.contract.Contract.IStringLeftLiteral");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:2477:4: ( (lv_parts_2_0= ruleIStringInter ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==RULE_ID||LA53_0==44) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalContract.g:2478:5: (lv_parts_2_0= ruleIStringInter )
                            {
                            // InternalContract.g:2478:5: (lv_parts_2_0= ruleIStringInter )
                            // InternalContract.g:2479:6: lv_parts_2_0= ruleIStringInter
                            {

                            						newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringInterParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_62);
                            lv_parts_2_0=ruleIStringInter();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getIStringRule());
                            						}
                            						add(
                            							current,
                            							"parts",
                            							lv_parts_2_0,
                            							"org.osate.contract.Contract.IStringInter");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalContract.g:2496:4: ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==RULE_ISTRING_MIDDLE) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalContract.g:2497:5: ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )?
                    	    {
                    	    // InternalContract.g:2497:5: ( (lv_parts_3_0= ruleIStringMiddleLiteral ) )
                    	    // InternalContract.g:2498:6: (lv_parts_3_0= ruleIStringMiddleLiteral )
                    	    {
                    	    // InternalContract.g:2498:6: (lv_parts_3_0= ruleIStringMiddleLiteral )
                    	    // InternalContract.g:2499:7: lv_parts_3_0= ruleIStringMiddleLiteral
                    	    {

                    	    							newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringMiddleLiteralParserRuleCall_1_2_0_0());
                    	    						
                    	    pushFollow(FOLLOW_62);
                    	    lv_parts_3_0=ruleIStringMiddleLiteral();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getIStringRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parts",
                    	    								lv_parts_3_0,
                    	    								"org.osate.contract.Contract.IStringMiddleLiteral");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    // InternalContract.g:2516:5: ( (lv_parts_4_0= ruleIStringInter ) )?
                    	    int alt54=2;
                    	    int LA54_0 = input.LA(1);

                    	    if ( (LA54_0==RULE_ID||LA54_0==44) ) {
                    	        alt54=1;
                    	    }
                    	    switch (alt54) {
                    	        case 1 :
                    	            // InternalContract.g:2517:6: (lv_parts_4_0= ruleIStringInter )
                    	            {
                    	            // InternalContract.g:2517:6: (lv_parts_4_0= ruleIStringInter )
                    	            // InternalContract.g:2518:7: lv_parts_4_0= ruleIStringInter
                    	            {

                    	            							newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringInterParserRuleCall_1_2_1_0());
                    	            						
                    	            pushFollow(FOLLOW_62);
                    	            lv_parts_4_0=ruleIStringInter();

                    	            state._fsp--;


                    	            							if (current==null) {
                    	            								current = createModelElementForParent(grammarAccess.getIStringRule());
                    	            							}
                    	            							add(
                    	            								current,
                    	            								"parts",
                    	            								lv_parts_4_0,
                    	            								"org.osate.contract.Contract.IStringInter");
                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);

                    // InternalContract.g:2536:4: ( (lv_parts_5_0= ruleIStringRightLiteral ) )
                    // InternalContract.g:2537:5: (lv_parts_5_0= ruleIStringRightLiteral )
                    {
                    // InternalContract.g:2537:5: (lv_parts_5_0= ruleIStringRightLiteral )
                    // InternalContract.g:2538:6: lv_parts_5_0= ruleIStringRightLiteral
                    {

                    						newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringRightLiteralParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_parts_5_0=ruleIStringRightLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIStringRule());
                    						}
                    						add(
                    							current,
                    							"parts",
                    							lv_parts_5_0,
                    							"org.osate.contract.Contract.IStringRightLiteral");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIString"


    // $ANTLR start "entryRuleIStringLiteral"
    // InternalContract.g:2560:1: entryRuleIStringLiteral returns [EObject current=null] : iv_ruleIStringLiteral= ruleIStringLiteral EOF ;
    public final EObject entryRuleIStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIStringLiteral = null;


        try {
            // InternalContract.g:2560:55: (iv_ruleIStringLiteral= ruleIStringLiteral EOF )
            // InternalContract.g:2561:2: iv_ruleIStringLiteral= ruleIStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getIStringLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIStringLiteral=ruleIStringLiteral();

            state._fsp--;

             current =iv_ruleIStringLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIStringLiteral"


    // $ANTLR start "ruleIStringLiteral"
    // InternalContract.g:2567:1: ruleIStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_ISTRING_TEXT ) ) ;
    public final EObject ruleIStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:2573:2: ( ( (lv_value_0_0= RULE_ISTRING_TEXT ) ) )
            // InternalContract.g:2574:2: ( (lv_value_0_0= RULE_ISTRING_TEXT ) )
            {
            // InternalContract.g:2574:2: ( (lv_value_0_0= RULE_ISTRING_TEXT ) )
            // InternalContract.g:2575:3: (lv_value_0_0= RULE_ISTRING_TEXT )
            {
            // InternalContract.g:2575:3: (lv_value_0_0= RULE_ISTRING_TEXT )
            // InternalContract.g:2576:4: lv_value_0_0= RULE_ISTRING_TEXT
            {
            lv_value_0_0=(Token)match(input,RULE_ISTRING_TEXT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getIStringLiteralAccess().getValueISTRING_TEXTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIStringLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.osate.contract.Contract.ISTRING_TEXT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIStringLiteral"


    // $ANTLR start "entryRuleIStringLeftLiteral"
    // InternalContract.g:2595:1: entryRuleIStringLeftLiteral returns [EObject current=null] : iv_ruleIStringLeftLiteral= ruleIStringLeftLiteral EOF ;
    public final EObject entryRuleIStringLeftLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIStringLeftLiteral = null;


        try {
            // InternalContract.g:2595:59: (iv_ruleIStringLeftLiteral= ruleIStringLeftLiteral EOF )
            // InternalContract.g:2596:2: iv_ruleIStringLeftLiteral= ruleIStringLeftLiteral EOF
            {
             newCompositeNode(grammarAccess.getIStringLeftLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIStringLeftLiteral=ruleIStringLeftLiteral();

            state._fsp--;

             current =iv_ruleIStringLeftLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIStringLeftLiteral"


    // $ANTLR start "ruleIStringLeftLiteral"
    // InternalContract.g:2602:1: ruleIStringLeftLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_ISTRING_LEFT ) ) ;
    public final EObject ruleIStringLeftLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:2608:2: ( ( (lv_value_0_0= RULE_ISTRING_LEFT ) ) )
            // InternalContract.g:2609:2: ( (lv_value_0_0= RULE_ISTRING_LEFT ) )
            {
            // InternalContract.g:2609:2: ( (lv_value_0_0= RULE_ISTRING_LEFT ) )
            // InternalContract.g:2610:3: (lv_value_0_0= RULE_ISTRING_LEFT )
            {
            // InternalContract.g:2610:3: (lv_value_0_0= RULE_ISTRING_LEFT )
            // InternalContract.g:2611:4: lv_value_0_0= RULE_ISTRING_LEFT
            {
            lv_value_0_0=(Token)match(input,RULE_ISTRING_LEFT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getIStringLeftLiteralAccess().getValueISTRING_LEFTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIStringLeftLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.osate.contract.Contract.ISTRING_LEFT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIStringLeftLiteral"


    // $ANTLR start "entryRuleIStringMiddleLiteral"
    // InternalContract.g:2630:1: entryRuleIStringMiddleLiteral returns [EObject current=null] : iv_ruleIStringMiddleLiteral= ruleIStringMiddleLiteral EOF ;
    public final EObject entryRuleIStringMiddleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIStringMiddleLiteral = null;


        try {
            // InternalContract.g:2630:61: (iv_ruleIStringMiddleLiteral= ruleIStringMiddleLiteral EOF )
            // InternalContract.g:2631:2: iv_ruleIStringMiddleLiteral= ruleIStringMiddleLiteral EOF
            {
             newCompositeNode(grammarAccess.getIStringMiddleLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIStringMiddleLiteral=ruleIStringMiddleLiteral();

            state._fsp--;

             current =iv_ruleIStringMiddleLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIStringMiddleLiteral"


    // $ANTLR start "ruleIStringMiddleLiteral"
    // InternalContract.g:2637:1: ruleIStringMiddleLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_ISTRING_MIDDLE ) ) ;
    public final EObject ruleIStringMiddleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:2643:2: ( ( (lv_value_0_0= RULE_ISTRING_MIDDLE ) ) )
            // InternalContract.g:2644:2: ( (lv_value_0_0= RULE_ISTRING_MIDDLE ) )
            {
            // InternalContract.g:2644:2: ( (lv_value_0_0= RULE_ISTRING_MIDDLE ) )
            // InternalContract.g:2645:3: (lv_value_0_0= RULE_ISTRING_MIDDLE )
            {
            // InternalContract.g:2645:3: (lv_value_0_0= RULE_ISTRING_MIDDLE )
            // InternalContract.g:2646:4: lv_value_0_0= RULE_ISTRING_MIDDLE
            {
            lv_value_0_0=(Token)match(input,RULE_ISTRING_MIDDLE,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getIStringMiddleLiteralAccess().getValueISTRING_MIDDLETerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIStringMiddleLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.osate.contract.Contract.ISTRING_MIDDLE");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIStringMiddleLiteral"


    // $ANTLR start "entryRuleIStringRightLiteral"
    // InternalContract.g:2665:1: entryRuleIStringRightLiteral returns [EObject current=null] : iv_ruleIStringRightLiteral= ruleIStringRightLiteral EOF ;
    public final EObject entryRuleIStringRightLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIStringRightLiteral = null;


        try {
            // InternalContract.g:2665:60: (iv_ruleIStringRightLiteral= ruleIStringRightLiteral EOF )
            // InternalContract.g:2666:2: iv_ruleIStringRightLiteral= ruleIStringRightLiteral EOF
            {
             newCompositeNode(grammarAccess.getIStringRightLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIStringRightLiteral=ruleIStringRightLiteral();

            state._fsp--;

             current =iv_ruleIStringRightLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIStringRightLiteral"


    // $ANTLR start "ruleIStringRightLiteral"
    // InternalContract.g:2672:1: ruleIStringRightLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_ISTRING_RIGHT ) ) ;
    public final EObject ruleIStringRightLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:2678:2: ( ( (lv_value_0_0= RULE_ISTRING_RIGHT ) ) )
            // InternalContract.g:2679:2: ( (lv_value_0_0= RULE_ISTRING_RIGHT ) )
            {
            // InternalContract.g:2679:2: ( (lv_value_0_0= RULE_ISTRING_RIGHT ) )
            // InternalContract.g:2680:3: (lv_value_0_0= RULE_ISTRING_RIGHT )
            {
            // InternalContract.g:2680:3: (lv_value_0_0= RULE_ISTRING_RIGHT )
            // InternalContract.g:2681:4: lv_value_0_0= RULE_ISTRING_RIGHT
            {
            lv_value_0_0=(Token)match(input,RULE_ISTRING_RIGHT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getIStringRightLiteralAccess().getValueISTRING_RIGHTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIStringRightLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.osate.contract.Contract.ISTRING_RIGHT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIStringRightLiteral"


    // $ANTLR start "entryRuleIStringInter"
    // InternalContract.g:2700:1: entryRuleIStringInter returns [EObject current=null] : iv_ruleIStringInter= ruleIStringInter EOF ;
    public final EObject entryRuleIStringInter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIStringInter = null;


        try {
            // InternalContract.g:2700:53: (iv_ruleIStringInter= ruleIStringInter EOF )
            // InternalContract.g:2701:2: iv_ruleIStringInter= ruleIStringInter EOF
            {
             newCompositeNode(grammarAccess.getIStringInterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIStringInter=ruleIStringInter();

            state._fsp--;

             current =iv_ruleIStringInter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIStringInter"


    // $ANTLR start "ruleIStringInter"
    // InternalContract.g:2707:1: ruleIStringInter returns [EObject current=null] : ( ( (lv_direct_0_0= ':' ) )? ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleIStringInter() throws RecognitionException {
        EObject current = null;

        Token lv_direct_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalContract.g:2713:2: ( ( ( (lv_direct_0_0= ':' ) )? ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ) )
            // InternalContract.g:2714:2: ( ( (lv_direct_0_0= ':' ) )? ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalContract.g:2714:2: ( ( (lv_direct_0_0= ':' ) )? ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) )
            // InternalContract.g:2715:3: ( (lv_direct_0_0= ':' ) )? ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) )
            {
            // InternalContract.g:2715:3: ( (lv_direct_0_0= ':' ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==44) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalContract.g:2716:4: (lv_direct_0_0= ':' )
                    {
                    // InternalContract.g:2716:4: (lv_direct_0_0= ':' )
                    // InternalContract.g:2717:5: lv_direct_0_0= ':'
                    {
                    lv_direct_0_0=(Token)match(input,44,FOLLOW_4); 

                    					newLeafNode(lv_direct_0_0, grammarAccess.getIStringInterAccess().getDirectColonKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIStringInterRule());
                    					}
                    					setWithLastConsumed(current, "direct", lv_direct_0_0 != null, ":");
                    				

                    }


                    }
                    break;

            }

            // InternalContract.g:2729:3: ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==60) ) {
                    alt58=1;
                }
            }
            switch (alt58) {
                case 1 :
                    // InternalContract.g:2730:4: ( (otherlv_1= RULE_ID ) ) otherlv_2= '::'
                    {
                    // InternalContract.g:2730:4: ( (otherlv_1= RULE_ID ) )
                    // InternalContract.g:2731:5: (otherlv_1= RULE_ID )
                    {
                    // InternalContract.g:2731:5: (otherlv_1= RULE_ID )
                    // InternalContract.g:2732:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIStringInterRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_63); 

                    						newLeafNode(otherlv_1, grammarAccess.getIStringInterAccess().getDomainDomainCrossReference_1_0_0());
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,60,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getIStringInterAccess().getColonColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalContract.g:2748:3: ( (otherlv_3= RULE_ID ) )
            // InternalContract.g:2749:4: (otherlv_3= RULE_ID )
            {
            // InternalContract.g:2749:4: (otherlv_3= RULE_ID )
            // InternalContract.g:2750:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIStringInterRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_3, grammarAccess.getIStringInterAccess().getQuerySingleValDeclarationCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIStringInter"


    // $ANTLR start "entryRuleContainedPropertyAssociation"
    // InternalContract.g:2765:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalContract.g:2765:69: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalContract.g:2766:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
            {
             newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation();

            state._fsp--;

             current =iv_ruleContainedPropertyAssociation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainedPropertyAssociation"


    // $ANTLR start "ruleContainedPropertyAssociation"
    // InternalContract.g:2772:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' ) ;
    public final EObject ruleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        EObject lv_ownedValue_4_0 = null;

        EObject lv_ownedValue_6_0 = null;

        EObject lv_appliesTo_8_0 = null;

        EObject lv_appliesTo_10_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2778:2: ( ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' ) )
            // InternalContract.g:2779:2: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' )
            {
            // InternalContract.g:2779:2: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' )
            // InternalContract.g:2780:3: ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';'
            {
            // InternalContract.g:2780:3: ( ( ruleQPREF ) )
            // InternalContract.g:2781:4: ( ruleQPREF )
            {
            // InternalContract.g:2781:4: ( ruleQPREF )
            // InternalContract.g:2782:5: ruleQPREF
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
            				
            pushFollow(FOLLOW_64);
            ruleQPREF();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalContract.g:2796:3: (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==32) ) {
                alt59=1;
            }
            else if ( (LA59_0==61) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalContract.g:2797:4: otherlv_1= '=>'
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_65); 

                    				newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalContract.g:2802:4: ( (lv_append_2_0= '+=>' ) )
                    {
                    // InternalContract.g:2802:4: ( (lv_append_2_0= '+=>' ) )
                    // InternalContract.g:2803:5: (lv_append_2_0= '+=>' )
                    {
                    // InternalContract.g:2803:5: (lv_append_2_0= '+=>' )
                    // InternalContract.g:2804:6: lv_append_2_0= '+=>'
                    {
                    lv_append_2_0=(Token)match(input,61,FOLLOW_65); 

                    						newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    						}
                    						setWithLastConsumed(current, "append", lv_append_2_0 != null, "+=>");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalContract.g:2817:3: ( (lv_constant_3_0= 'constant' ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==62) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalContract.g:2818:4: (lv_constant_3_0= 'constant' )
                    {
                    // InternalContract.g:2818:4: (lv_constant_3_0= 'constant' )
                    // InternalContract.g:2819:5: lv_constant_3_0= 'constant'
                    {
                    lv_constant_3_0=(Token)match(input,62,FOLLOW_65); 

                    					newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    					}
                    					setWithLastConsumed(current, "constant", lv_constant_3_0 != null, "constant");
                    				

                    }


                    }
                    break;

            }

            // InternalContract.g:2831:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalContract.g:2832:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalContract.g:2832:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalContract.g:2833:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalContract.g:2833:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalContract.g:2834:6: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {

            						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());
            					
            pushFollow(FOLLOW_66);
            lv_ownedValue_4_0=ruleOptionalModalPropertyValue();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            						}
            						add(
            							current,
            							"ownedValue",
            							lv_ownedValue_4_0,
            							"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalContract.g:2851:4: (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==48) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalContract.g:2852:5: otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,48,FOLLOW_65); 

            	    					newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	    				
            	    // InternalContract.g:2856:5: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalContract.g:2857:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalContract.g:2857:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalContract.g:2858:7: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {

            	    							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());
            	    						
            	    pushFollow(FOLLOW_66);
            	    lv_ownedValue_6_0=ruleOptionalModalPropertyValue();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            	    							}
            	    							add(
            	    								current,
            	    								"ownedValue",
            	    								lv_ownedValue_6_0,
            	    								"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }

            // InternalContract.g:2877:3: ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==74) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalContract.g:2878:4: ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    {

                    				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0());
                    			
                    pushFollow(FOLLOW_4);
                    ruleAppliesToKeywords();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			
                    // InternalContract.g:2885:4: ( (lv_appliesTo_8_0= ruleContainmentPath ) )
                    // InternalContract.g:2886:5: (lv_appliesTo_8_0= ruleContainmentPath )
                    {
                    // InternalContract.g:2886:5: (lv_appliesTo_8_0= ruleContainmentPath )
                    // InternalContract.g:2887:6: lv_appliesTo_8_0= ruleContainmentPath
                    {

                    						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_appliesTo_8_0=ruleContainmentPath();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    						}
                    						add(
                    							current,
                    							"appliesTo",
                    							lv_appliesTo_8_0,
                    							"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:2904:4: (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==48) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalContract.g:2905:5: otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_9=(Token)match(input,48,FOLLOW_4); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalContract.g:2909:5: ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    // InternalContract.g:2910:6: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    {
                    	    // InternalContract.g:2910:6: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    // InternalContract.g:2911:7: lv_appliesTo_10_0= ruleContainmentPath
                    	    {

                    	    							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_67);
                    	    lv_appliesTo_10_0=ruleContainmentPath();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"appliesTo",
                    	    								lv_appliesTo_10_0,
                    	    								"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalContract.g:2930:3: ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==76) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalContract.g:2931:4: ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')'
                    {

                    				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0());
                    			
                    pushFollow(FOLLOW_35);
                    ruleInBindingKeywords();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_12=(Token)match(input,39,FOLLOW_4); 

                    				newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1());
                    			
                    // InternalContract.g:2942:4: ( ( ruleQCREF ) )
                    // InternalContract.g:2943:5: ( ruleQCREF )
                    {
                    // InternalContract.g:2943:5: ( ruleQCREF )
                    // InternalContract.g:2944:6: ruleQCREF
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0());
                    					
                    pushFollow(FOLLOW_55);
                    ruleQCREF();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,40,FOLLOW_17); 

                    				newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3());
                    			

                    }
                    break;

            }

            otherlv_15=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainedPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPath"
    // InternalContract.g:2971:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalContract.g:2971:56: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalContract.g:2972:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
             newCompositeNode(grammarAccess.getContainmentPathRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;

             current =iv_ruleContainmentPath; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPath"


    // $ANTLR start "ruleContainmentPath"
    // InternalContract.g:2978:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2984:2: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalContract.g:2985:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalContract.g:2985:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalContract.g:2986:3: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalContract.g:2986:3: (lv_path_0_0= ruleContainmentPathElement )
            // InternalContract.g:2987:4: lv_path_0_0= ruleContainmentPathElement
            {

            				newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_path_0_0=ruleContainmentPathElement();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getContainmentPathRule());
            				}
            				set(
            					current,
            					"path",
            					lv_path_0_0,
            					"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentPath"


    // $ANTLR start "entryRuleOptionalModalPropertyValue"
    // InternalContract.g:3007:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalContract.g:3007:67: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalContract.g:3008:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
            {
             newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue();

            state._fsp--;

             current =iv_ruleOptionalModalPropertyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptionalModalPropertyValue"


    // $ANTLR start "ruleOptionalModalPropertyValue"
    // InternalContract.g:3014:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= ')' )? ) ;
    public final EObject ruleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_ownedValue_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:3020:2: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= ')' )? ) )
            // InternalContract.g:3021:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= ')' )? )
            {
            // InternalContract.g:3021:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= ')' )? )
            // InternalContract.g:3022:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= ')' )?
            {
            // InternalContract.g:3022:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalContract.g:3023:4: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalContract.g:3023:4: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalContract.g:3024:5: lv_ownedValue_0_0= rulePropertyExpression
            {

            					newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_68);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
            					}
            					set(
            						current,
            						"ownedValue",
            						lv_ownedValue_0_0,
            						"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalContract.g:3041:3: ( ruleInModesKeywords otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= ')' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==76) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==78) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // InternalContract.g:3042:4: ruleInModesKeywords otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= ')'
                    {

                    				newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_35);
                    ruleInModesKeywords();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,39,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalContract.g:3053:4: ( (otherlv_3= RULE_ID ) )
                    // InternalContract.g:3054:5: (otherlv_3= RULE_ID )
                    {
                    // InternalContract.g:3054:5: (otherlv_3= RULE_ID )
                    // InternalContract.g:3055:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_47); 

                    						newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0());
                    					

                    }


                    }

                    // InternalContract.g:3066:4: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==48) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // InternalContract.g:3067:5: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,48,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
                    	    				
                    	    // InternalContract.g:3071:5: ( (otherlv_5= RULE_ID ) )
                    	    // InternalContract.g:3072:6: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalContract.g:3072:6: (otherlv_5= RULE_ID )
                    	    // InternalContract.g:3073:7: otherlv_5= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	    							}
                    	    						
                    	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_47); 

                    	    							newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,40,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptionalModalPropertyValue"


    // $ANTLR start "entryRulePropertyValue"
    // InternalContract.g:3094:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalContract.g:3094:54: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalContract.g:3095:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
             newCompositeNode(grammarAccess.getPropertyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;

             current =iv_rulePropertyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyValue"


    // $ANTLR start "rulePropertyValue"
    // InternalContract.g:3101:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:3107:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalContract.g:3108:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalContract.g:3108:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalContract.g:3109:3: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalContract.g:3109:3: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalContract.g:3110:4: lv_ownedValue_0_0= rulePropertyExpression
            {

            				newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getPropertyValueRule());
            				}
            				set(
            					current,
            					"ownedValue",
            					lv_ownedValue_0_0,
            					"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyValue"


    // $ANTLR start "entryRulePropertyExpression"
    // InternalContract.g:3130:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalContract.g:3130:59: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalContract.g:3131:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
             newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;

             current =iv_rulePropertyExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyExpression"


    // $ANTLR start "rulePropertyExpression"
    // InternalContract.g:3137:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RecordTerm_0 = null;

        EObject this_ReferenceTerm_1 = null;

        EObject this_ComponentClassifierTerm_2 = null;

        EObject this_ComputedTerm_3 = null;

        EObject this_StringTerm_4 = null;

        EObject this_NumericRangeTerm_5 = null;

        EObject this_RealTerm_6 = null;

        EObject this_IntegerTerm_7 = null;

        EObject this_ListTerm_8 = null;

        EObject this_BooleanLiteral_9 = null;

        EObject this_LiteralorReferenceTerm_10 = null;



        	enterRule();

        try {
            // InternalContract.g:3143:2: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) )
            // InternalContract.g:3144:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            {
            // InternalContract.g:3144:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            int alt67=11;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // InternalContract.g:3145:3: this_RecordTerm_0= ruleRecordTerm
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RecordTerm_0=ruleRecordTerm();

                    state._fsp--;


                    			current = this_RecordTerm_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalContract.g:3154:3: this_ReferenceTerm_1= ruleReferenceTerm
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReferenceTerm_1=ruleReferenceTerm();

                    state._fsp--;


                    			current = this_ReferenceTerm_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalContract.g:3163:3: this_ComponentClassifierTerm_2= ruleComponentClassifierTerm
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ComponentClassifierTerm_2=ruleComponentClassifierTerm();

                    state._fsp--;


                    			current = this_ComponentClassifierTerm_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalContract.g:3172:3: this_ComputedTerm_3= ruleComputedTerm
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ComputedTerm_3=ruleComputedTerm();

                    state._fsp--;


                    			current = this_ComputedTerm_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalContract.g:3181:3: this_StringTerm_4= ruleStringTerm
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringTerm_4=ruleStringTerm();

                    state._fsp--;


                    			current = this_StringTerm_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalContract.g:3190:3: this_NumericRangeTerm_5= ruleNumericRangeTerm
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericRangeTerm_5=ruleNumericRangeTerm();

                    state._fsp--;


                    			current = this_NumericRangeTerm_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalContract.g:3199:3: this_RealTerm_6= ruleRealTerm
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_RealTerm_6=ruleRealTerm();

                    state._fsp--;


                    			current = this_RealTerm_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalContract.g:3208:3: this_IntegerTerm_7= ruleIntegerTerm
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerTerm_7=ruleIntegerTerm();

                    state._fsp--;


                    			current = this_IntegerTerm_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalContract.g:3217:3: this_ListTerm_8= ruleListTerm
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_ListTerm_8=ruleListTerm();

                    state._fsp--;


                    			current = this_ListTerm_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalContract.g:3226:3: this_BooleanLiteral_9= ruleBooleanLiteral
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_9=ruleBooleanLiteral();

                    state._fsp--;


                    			current = this_BooleanLiteral_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalContract.g:3235:3: this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm
                    {

                    			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralorReferenceTerm_10=ruleLiteralorReferenceTerm();

                    state._fsp--;


                    			current = this_LiteralorReferenceTerm_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyExpression"


    // $ANTLR start "entryRuleLiteralorReferenceTerm"
    // InternalContract.g:3247:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalContract.g:3247:63: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalContract.g:3248:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
            {
             newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm();

            state._fsp--;

             current =iv_ruleLiteralorReferenceTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralorReferenceTerm"


    // $ANTLR start "ruleLiteralorReferenceTerm"
    // InternalContract.g:3254:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalContract.g:3260:2: ( ( ( ruleQPREF ) ) )
            // InternalContract.g:3261:2: ( ( ruleQPREF ) )
            {
            // InternalContract.g:3261:2: ( ( ruleQPREF ) )
            // InternalContract.g:3262:3: ( ruleQPREF )
            {
            // InternalContract.g:3262:3: ( ruleQPREF )
            // InternalContract.g:3263:4: ruleQPREF
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
            				}
            			

            				newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQPREF();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralorReferenceTerm"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalContract.g:3280:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalContract.g:3280:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalContract.g:3281:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalContract.g:3287:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalContract.g:3293:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalContract.g:3294:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalContract.g:3294:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalContract.g:3295:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalContract.g:3295:3: ()
            // InternalContract.g:3296:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalContract.g:3302:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==63) ) {
                alt68=1;
            }
            else if ( (LA68_0==64) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalContract.g:3303:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalContract.g:3303:4: ( (lv_value_1_0= 'true' ) )
                    // InternalContract.g:3304:5: (lv_value_1_0= 'true' )
                    {
                    // InternalContract.g:3304:5: (lv_value_1_0= 'true' )
                    // InternalContract.g:3305:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,63,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:3318:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,64,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleConstantValue"
    // InternalContract.g:3327:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalContract.g:3327:54: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalContract.g:3328:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
             newCompositeNode(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;

             current =iv_ruleConstantValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantValue"


    // $ANTLR start "ruleConstantValue"
    // InternalContract.g:3334:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalContract.g:3340:2: ( ( ( ruleQPREF ) ) )
            // InternalContract.g:3341:2: ( ( ruleQPREF ) )
            {
            // InternalContract.g:3341:2: ( ( ruleQPREF ) )
            // InternalContract.g:3342:3: ( ruleQPREF )
            {
            // InternalContract.g:3342:3: ( ruleQPREF )
            // InternalContract.g:3343:4: ruleQPREF
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getConstantValueRule());
            				}
            			

            				newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQPREF();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleReferenceTerm"
    // InternalContract.g:3360:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalContract.g:3360:54: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalContract.g:3361:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
             newCompositeNode(grammarAccess.getReferenceTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;

             current =iv_ruleReferenceTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceTerm"


    // $ANTLR start "ruleReferenceTerm"
    // InternalContract.g:3367:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;



        	enterRule();

        try {
            // InternalContract.g:3373:2: ( (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) )
            // InternalContract.g:3374:2: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            {
            // InternalContract.g:3374:2: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            // InternalContract.g:3375:3: otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_35); 

            			newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
            		
            // InternalContract.g:3383:3: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalContract.g:3384:4: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalContract.g:3384:4: (lv_path_2_0= ruleContainmentPathElement )
            // InternalContract.g:3385:5: lv_path_2_0= ruleContainmentPathElement
            {

            					newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_55);
            lv_path_2_0=ruleContainmentPathElement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceTermRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_2_0,
            						"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceTerm"


    // $ANTLR start "entryRuleRecordTerm"
    // InternalContract.g:3410:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalContract.g:3410:51: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalContract.g:3411:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
             newCompositeNode(grammarAccess.getRecordTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;

             current =iv_ruleRecordTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordTerm"


    // $ANTLR start "ruleRecordTerm"
    // InternalContract.g:3417:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;



        	enterRule();

        try {
            // InternalContract.g:3423:2: ( (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) )
            // InternalContract.g:3424:2: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            {
            // InternalContract.g:3424:2: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            // InternalContract.g:3425:3: otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalContract.g:3429:3: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt69=0;
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_ID) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalContract.g:3430:4: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // InternalContract.g:3430:4: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // InternalContract.g:3431:5: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {

            	    					newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_69);
            	    lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRecordTermRule());
            	    					}
            	    					add(
            	    						current,
            	    						"ownedFieldValue",
            	    						lv_ownedFieldValue_1_0,
            	    						"org.osate.xtext.aadl2.properties.Properties.FieldPropertyAssociation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt69 >= 1 ) break loop69;
                        EarlyExitException eee =
                            new EarlyExitException(69, input);
                        throw eee;
                }
                cnt69++;
            } while (true);

            otherlv_2=(Token)match(input,67,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordTerm"


    // $ANTLR start "entryRuleComputedTerm"
    // InternalContract.g:3456:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalContract.g:3456:53: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalContract.g:3457:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
             newCompositeNode(grammarAccess.getComputedTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;

             current =iv_ruleComputedTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComputedTerm"


    // $ANTLR start "ruleComputedTerm"
    // InternalContract.g:3463:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalContract.g:3469:2: ( (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalContract.g:3470:2: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalContract.g:3470:2: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalContract.g:3471:3: otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,68,FOLLOW_35); 

            			newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
            		
            // InternalContract.g:3479:3: ( (lv_function_2_0= RULE_ID ) )
            // InternalContract.g:3480:4: (lv_function_2_0= RULE_ID )
            {
            // InternalContract.g:3480:4: (lv_function_2_0= RULE_ID )
            // InternalContract.g:3481:5: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FOLLOW_55); 

            					newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComputedTermRule());
            					}
            					setWithLastConsumed(
            						current,
            						"function",
            						lv_function_2_0,
            						"org.osate.xtext.aadl2.properties.Properties.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComputedTerm"


    // $ANTLR start "entryRuleComponentClassifierTerm"
    // InternalContract.g:3505:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalContract.g:3505:64: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalContract.g:3506:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
             newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;

             current =iv_ruleComponentClassifierTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentClassifierTerm"


    // $ANTLR start "ruleComponentClassifierTerm"
    // InternalContract.g:3512:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalContract.g:3518:2: ( (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) )
            // InternalContract.g:3519:2: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            {
            // InternalContract.g:3519:2: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            // InternalContract.g:3520:3: otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_35); 

            			newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
            		
            otherlv_1=(Token)match(input,39,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
            		
            // InternalContract.g:3528:3: ( ( ruleQCREF ) )
            // InternalContract.g:3529:4: ( ruleQCREF )
            {
            // InternalContract.g:3529:4: ( ruleQCREF )
            // InternalContract.g:3530:5: ruleQCREF
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentClassifierTermRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0());
            				
            pushFollow(FOLLOW_55);
            ruleQCREF();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentClassifierTerm"


    // $ANTLR start "entryRuleListTerm"
    // InternalContract.g:3552:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalContract.g:3552:49: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalContract.g:3553:2: iv_ruleListTerm= ruleListTerm EOF
            {
             newCompositeNode(grammarAccess.getListTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;

             current =iv_ruleListTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListTerm"


    // $ANTLR start "ruleListTerm"
    // InternalContract.g:3559:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;



        	enterRule();

        try {
            // InternalContract.g:3565:2: ( ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalContract.g:3566:2: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalContract.g:3566:2: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            // InternalContract.g:3567:3: () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalContract.g:3567:3: ()
            // InternalContract.g:3568:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getListTermAccess().getListValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,39,FOLLOW_70); 

            			newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
            		
            // InternalContract.g:3578:3: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ID||(LA71_0>=RULE_STRING && LA71_0<=RULE_REAL_LIT)||LA71_0==39||(LA71_0>=63 && LA71_0<=66)||(LA71_0>=68 && LA71_0<=71)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalContract.g:3579:4: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalContract.g:3579:4: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalContract.g:3580:5: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalContract.g:3580:5: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalContract.g:3581:6: lv_ownedListElement_2_0= rulePropertyExpression
                    {

                    						newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_47);
                    lv_ownedListElement_2_0=rulePropertyExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getListTermRule());
                    						}
                    						add(
                    							current,
                    							"ownedListElement",
                    							lv_ownedListElement_2_0,
                    							"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:3598:4: (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==48) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalContract.g:3599:5: otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,48,FOLLOW_65); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalContract.g:3603:5: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // InternalContract.g:3604:6: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // InternalContract.g:3604:6: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // InternalContract.g:3605:7: lv_ownedListElement_4_0= rulePropertyExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_47);
                    	    lv_ownedListElement_4_0=rulePropertyExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getListTermRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"ownedListElement",
                    	    								lv_ownedListElement_4_0,
                    	    								"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListTerm"


    // $ANTLR start "entryRuleFieldPropertyAssociation"
    // InternalContract.g:3632:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalContract.g:3632:65: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalContract.g:3633:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
            {
             newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation();

            state._fsp--;

             current =iv_ruleFieldPropertyAssociation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldPropertyAssociation"


    // $ANTLR start "ruleFieldPropertyAssociation"
    // InternalContract.g:3639:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;



        	enterRule();

        try {
            // InternalContract.g:3645:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) )
            // InternalContract.g:3646:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            {
            // InternalContract.g:3646:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            // InternalContract.g:3647:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';'
            {
            // InternalContract.g:3647:3: ( (otherlv_0= RULE_ID ) )
            // InternalContract.g:3648:4: (otherlv_0= RULE_ID )
            {
            // InternalContract.g:3648:4: (otherlv_0= RULE_ID )
            // InternalContract.g:3649:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_71); 

            					newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_65); 

            			newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
            		
            // InternalContract.g:3664:3: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalContract.g:3665:4: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalContract.g:3665:4: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalContract.g:3666:5: lv_ownedValue_2_0= rulePropertyExpression
            {

            					newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_ownedValue_2_0=rulePropertyExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
            					}
            					set(
            						current,
            						"ownedValue",
            						lv_ownedValue_2_0,
            						"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPathElement"
    // InternalContract.g:3691:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalContract.g:3691:63: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalContract.g:3692:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
             newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;

             current =iv_ruleContainmentPathElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPathElement"


    // $ANTLR start "ruleContainmentPathElement"
    // InternalContract.g:3698:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= '.' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;



        	enterRule();

        try {
            // InternalContract.g:3704:2: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= '.' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalContract.g:3705:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= '.' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalContract.g:3705:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= '.' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalContract.g:3706:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= '.' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalContract.g:3706:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalContract.g:3707:4: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalContract.g:3707:4: ( (otherlv_0= RULE_ID ) )
            // InternalContract.g:3708:5: (otherlv_0= RULE_ID )
            {
            // InternalContract.g:3708:5: (otherlv_0= RULE_ID )
            // InternalContract.g:3709:6: otherlv_0= RULE_ID
            {

            						if (current==null) {
            							current = createModelElement(grammarAccess.getContainmentPathElementRule());
            						}
            					
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_72); 

            						newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0());
            					

            }


            }

            // InternalContract.g:3720:4: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==66) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalContract.g:3721:5: (lv_arrayRange_1_0= ruleArrayRange )
            	    {
            	    // InternalContract.g:3721:5: (lv_arrayRange_1_0= ruleArrayRange )
            	    // InternalContract.g:3722:6: lv_arrayRange_1_0= ruleArrayRange
            	    {

            	    						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0());
            	    					
            	    pushFollow(FOLLOW_72);
            	    lv_arrayRange_1_0=ruleArrayRange();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
            	    						}
            	    						add(
            	    							current,
            	    							"arrayRange",
            	    							lv_arrayRange_1_0,
            	    							"org.osate.xtext.aadl2.properties.Properties.ArrayRange");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }

            // InternalContract.g:3740:3: (otherlv_2= '.' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==53) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalContract.g:3741:4: otherlv_2= '.' ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,53,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
                    			
                    // InternalContract.g:3745:4: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalContract.g:3746:5: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalContract.g:3746:5: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalContract.g:3747:6: lv_path_3_0= ruleContainmentPathElement
                    {

                    						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_path_3_0=ruleContainmentPathElement();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
                    						}
                    						set(
                    							current,
                    							"path",
                    							lv_path_3_0,
                    							"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentPathElement"


    // $ANTLR start "entryRulePlusMinus"
    // InternalContract.g:3769:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalContract.g:3769:49: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalContract.g:3770:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
             newCompositeNode(grammarAccess.getPlusMinusRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;

             current =iv_rulePlusMinus.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusMinus"


    // $ANTLR start "rulePlusMinus"
    // InternalContract.g:3776:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalContract.g:3782:2: ( (kw= '+' | kw= '-' ) )
            // InternalContract.g:3783:2: (kw= '+' | kw= '-' )
            {
            // InternalContract.g:3783:2: (kw= '+' | kw= '-' )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==70) ) {
                alt74=1;
            }
            else if ( (LA74_0==71) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalContract.g:3784:3: kw= '+'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalContract.g:3790:3: kw= '-'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusMinus"


    // $ANTLR start "entryRuleStringTerm"
    // InternalContract.g:3799:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalContract.g:3799:51: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalContract.g:3800:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
             newCompositeNode(grammarAccess.getStringTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;

             current =iv_ruleStringTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringTerm"


    // $ANTLR start "ruleStringTerm"
    // InternalContract.g:3806:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:3812:2: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalContract.g:3813:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalContract.g:3813:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalContract.g:3814:3: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalContract.g:3814:3: (lv_value_0_0= ruleNoQuoteString )
            // InternalContract.g:3815:4: lv_value_0_0= ruleNoQuoteString
            {

            				newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleNoQuoteString();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getStringTermRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringTerm"


    // $ANTLR start "entryRuleNoQuoteString"
    // InternalContract.g:3835:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalContract.g:3835:53: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalContract.g:3836:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
             newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;

             current =iv_ruleNoQuoteString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNoQuoteString"


    // $ANTLR start "ruleNoQuoteString"
    // InternalContract.g:3842:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalContract.g:3848:2: (this_STRING_0= RULE_STRING )
            // InternalContract.g:3849:2: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            		current.merge(this_STRING_0);
            	

            		newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNoQuoteString"


    // $ANTLR start "entryRuleArrayRange"
    // InternalContract.g:3859:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalContract.g:3859:51: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalContract.g:3860:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
             newCompositeNode(grammarAccess.getArrayRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;

             current =iv_ruleArrayRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayRange"


    // $ANTLR start "ruleArrayRange"
    // InternalContract.g:3866:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;



        	enterRule();

        try {
            // InternalContract.g:3872:2: ( ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) )
            // InternalContract.g:3873:2: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            {
            // InternalContract.g:3873:2: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            // InternalContract.g:3874:3: () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']'
            {
            // InternalContract.g:3874:3: ()
            // InternalContract.g:3875:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,66,FOLLOW_73); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalContract.g:3885:3: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalContract.g:3886:4: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalContract.g:3886:4: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalContract.g:3887:5: lv_lowerBound_2_0= ruleINTVALUE
            {

            					newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_74);
            lv_lowerBound_2_0=ruleINTVALUE();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArrayRangeRule());
            					}
            					set(
            						current,
            						"lowerBound",
            						lv_lowerBound_2_0,
            						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalContract.g:3904:3: (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==72) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalContract.g:3905:4: otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,72,FOLLOW_73); 

                    				newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                    			
                    // InternalContract.g:3909:4: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalContract.g:3910:5: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalContract.g:3910:5: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalContract.g:3911:6: lv_upperBound_4_0= ruleINTVALUE
                    {

                    						newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_75);
                    lv_upperBound_4_0=ruleINTVALUE();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArrayRangeRule());
                    						}
                    						set(
                    							current,
                    							"upperBound",
                    							lv_upperBound_4_0,
                    							"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,67,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayRange"


    // $ANTLR start "entryRuleSignedConstant"
    // InternalContract.g:3937:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalContract.g:3937:55: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalContract.g:3938:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
             newCompositeNode(grammarAccess.getSignedConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;

             current =iv_ruleSignedConstant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedConstant"


    // $ANTLR start "ruleSignedConstant"
    // InternalContract.g:3944:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;



        	enterRule();

        try {
            // InternalContract.g:3950:2: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalContract.g:3951:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalContract.g:3951:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalContract.g:3952:3: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalContract.g:3952:3: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalContract.g:3953:4: (lv_op_0_0= rulePlusMinus )
            {
            // InternalContract.g:3953:4: (lv_op_0_0= rulePlusMinus )
            // InternalContract.g:3954:5: lv_op_0_0= rulePlusMinus
            {

            					newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_76);
            lv_op_0_0=rulePlusMinus();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSignedConstantRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_0_0,
            						"org.osate.xtext.aadl2.properties.Properties.PlusMinus");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalContract.g:3971:3: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalContract.g:3972:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalContract.g:3972:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalContract.g:3973:5: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {

            					newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_ownedPropertyExpression_1_0=ruleConstantValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSignedConstantRule());
            					}
            					add(
            						current,
            						"ownedPropertyExpression",
            						lv_ownedPropertyExpression_1_0,
            						"org.osate.xtext.aadl2.properties.Properties.ConstantValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedConstant"


    // $ANTLR start "entryRuleIntegerTerm"
    // InternalContract.g:3994:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalContract.g:3994:52: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalContract.g:3995:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
             newCompositeNode(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;

             current =iv_ruleIntegerTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerTerm"


    // $ANTLR start "ruleIntegerTerm"
    // InternalContract.g:4001:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:4007:2: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalContract.g:4008:2: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalContract.g:4008:2: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalContract.g:4009:3: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalContract.g:4009:3: ( (lv_value_0_0= ruleSignedInt ) )
            // InternalContract.g:4010:4: (lv_value_0_0= ruleSignedInt )
            {
            // InternalContract.g:4010:4: (lv_value_0_0= ruleSignedInt )
            // InternalContract.g:4011:5: lv_value_0_0= ruleSignedInt
            {

            					newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_77);
            lv_value_0_0=ruleSignedInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntegerTermRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_0_0,
            						"org.osate.xtext.aadl2.properties.Properties.SignedInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalContract.g:4028:3: ( (otherlv_1= RULE_ID ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalContract.g:4029:4: (otherlv_1= RULE_ID )
                    {
                    // InternalContract.g:4029:4: (otherlv_1= RULE_ID )
                    // InternalContract.g:4030:5: otherlv_1= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIntegerTermRule());
                    					}
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0());
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerTerm"


    // $ANTLR start "entryRuleSignedInt"
    // InternalContract.g:4045:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // InternalContract.g:4045:49: (iv_ruleSignedInt= ruleSignedInt EOF )
            // InternalContract.g:4046:2: iv_ruleSignedInt= ruleSignedInt EOF
            {
             newCompositeNode(grammarAccess.getSignedIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSignedInt=ruleSignedInt();

            state._fsp--;

             current =iv_ruleSignedInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedInt"


    // $ANTLR start "ruleSignedInt"
    // InternalContract.g:4052:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;


        	enterRule();

        try {
            // InternalContract.g:4058:2: ( ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalContract.g:4059:2: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalContract.g:4059:2: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalContract.g:4060:3: (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // InternalContract.g:4060:3: (kw= '+' | kw= '-' )?
            int alt77=3;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==70) ) {
                alt77=1;
            }
            else if ( (LA77_0==71) ) {
                alt77=2;
            }
            switch (alt77) {
                case 1 :
                    // InternalContract.g:4061:4: kw= '+'
                    {
                    kw=(Token)match(input,70,FOLLOW_73); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalContract.g:4067:4: kw= '-'
                    {
                    kw=(Token)match(input,71,FOLLOW_73); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1());
                    			

                    }
                    break;

            }

            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

            			current.merge(this_INTEGER_LIT_2);
            		

            			newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedInt"


    // $ANTLR start "entryRuleRealTerm"
    // InternalContract.g:4084:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalContract.g:4084:49: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalContract.g:4085:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
             newCompositeNode(grammarAccess.getRealTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;

             current =iv_ruleRealTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealTerm"


    // $ANTLR start "ruleRealTerm"
    // InternalContract.g:4091:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:4097:2: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalContract.g:4098:2: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalContract.g:4098:2: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalContract.g:4099:3: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalContract.g:4099:3: ( (lv_value_0_0= ruleSignedReal ) )
            // InternalContract.g:4100:4: (lv_value_0_0= ruleSignedReal )
            {
            // InternalContract.g:4100:4: (lv_value_0_0= ruleSignedReal )
            // InternalContract.g:4101:5: lv_value_0_0= ruleSignedReal
            {

            					newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_77);
            lv_value_0_0=ruleSignedReal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRealTermRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_0_0,
            						"org.osate.xtext.aadl2.properties.Properties.SignedReal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalContract.g:4118:3: ( (otherlv_1= RULE_ID ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalContract.g:4119:4: (otherlv_1= RULE_ID )
                    {
                    // InternalContract.g:4119:4: (otherlv_1= RULE_ID )
                    // InternalContract.g:4120:5: otherlv_1= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRealTermRule());
                    					}
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0());
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealTerm"


    // $ANTLR start "entryRuleSignedReal"
    // InternalContract.g:4135:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // InternalContract.g:4135:50: (iv_ruleSignedReal= ruleSignedReal EOF )
            // InternalContract.g:4136:2: iv_ruleSignedReal= ruleSignedReal EOF
            {
             newCompositeNode(grammarAccess.getSignedRealRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSignedReal=ruleSignedReal();

            state._fsp--;

             current =iv_ruleSignedReal.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedReal"


    // $ANTLR start "ruleSignedReal"
    // InternalContract.g:4142:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;


        	enterRule();

        try {
            // InternalContract.g:4148:2: ( ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // InternalContract.g:4149:2: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // InternalContract.g:4149:2: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            // InternalContract.g:4150:3: (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // InternalContract.g:4150:3: (kw= '+' | kw= '-' )?
            int alt79=3;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==70) ) {
                alt79=1;
            }
            else if ( (LA79_0==71) ) {
                alt79=2;
            }
            switch (alt79) {
                case 1 :
                    // InternalContract.g:4151:4: kw= '+'
                    {
                    kw=(Token)match(input,70,FOLLOW_78); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalContract.g:4157:4: kw= '-'
                    {
                    kw=(Token)match(input,71,FOLLOW_78); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1());
                    			

                    }
                    break;

            }

            this_REAL_LIT_2=(Token)match(input,RULE_REAL_LIT,FOLLOW_2); 

            			current.merge(this_REAL_LIT_2);
            		

            			newLeafNode(this_REAL_LIT_2, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedReal"


    // $ANTLR start "entryRuleNumericRangeTerm"
    // InternalContract.g:4174:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalContract.g:4174:57: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalContract.g:4175:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
             newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;

             current =iv_ruleNumericRangeTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericRangeTerm"


    // $ANTLR start "ruleNumericRangeTerm"
    // InternalContract.g:4181:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;



        	enterRule();

        try {
            // InternalContract.g:4187:2: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalContract.g:4188:2: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalContract.g:4188:2: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalContract.g:4189:3: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalContract.g:4189:3: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalContract.g:4190:4: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalContract.g:4190:4: (lv_minimum_0_0= ruleNumAlt )
            // InternalContract.g:4191:5: lv_minimum_0_0= ruleNumAlt
            {

            					newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_79);
            lv_minimum_0_0=ruleNumAlt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
            					}
            					set(
            						current,
            						"minimum",
            						lv_minimum_0_0,
            						"org.osate.xtext.aadl2.properties.Properties.NumAlt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_76); 

            			newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
            		
            // InternalContract.g:4212:3: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalContract.g:4213:4: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalContract.g:4213:4: (lv_maximum_2_0= ruleNumAlt )
            // InternalContract.g:4214:5: lv_maximum_2_0= ruleNumAlt
            {

            					newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_80);
            lv_maximum_2_0=ruleNumAlt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
            					}
            					set(
            						current,
            						"maximum",
            						lv_maximum_2_0,
            						"org.osate.xtext.aadl2.properties.Properties.NumAlt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalContract.g:4231:3: (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==73) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalContract.g:4232:4: otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,73,FOLLOW_76); 

                    				newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                    			
                    // InternalContract.g:4236:4: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalContract.g:4237:5: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalContract.g:4237:5: (lv_delta_4_0= ruleNumAlt )
                    // InternalContract.g:4238:6: lv_delta_4_0= ruleNumAlt
                    {

                    						newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_delta_4_0=ruleNumAlt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                    						}
                    						set(
                    							current,
                    							"delta",
                    							lv_delta_4_0,
                    							"org.osate.xtext.aadl2.properties.Properties.NumAlt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericRangeTerm"


    // $ANTLR start "entryRuleNumAlt"
    // InternalContract.g:4260:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalContract.g:4260:47: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalContract.g:4261:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
             newCompositeNode(grammarAccess.getNumAltRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;

             current =iv_ruleNumAlt; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumAlt"


    // $ANTLR start "ruleNumAlt"
    // InternalContract.g:4267:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;



        	enterRule();

        try {
            // InternalContract.g:4273:2: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalContract.g:4274:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalContract.g:4274:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt81=4;
            switch ( input.LA(1) ) {
            case 70:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt81=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt81=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt81=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 1, input);

                    throw nvae;
                }

                }
                break;
            case 71:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt81=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt81=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt81=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt81=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt81=2;
                }
                break;
            case RULE_ID:
                {
                alt81=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // InternalContract.g:4275:3: this_RealTerm_0= ruleRealTerm
                    {

                    			newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RealTerm_0=ruleRealTerm();

                    state._fsp--;


                    			current = this_RealTerm_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalContract.g:4284:3: this_IntegerTerm_1= ruleIntegerTerm
                    {

                    			newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerTerm_1=ruleIntegerTerm();

                    state._fsp--;


                    			current = this_IntegerTerm_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalContract.g:4293:3: this_SignedConstant_2= ruleSignedConstant
                    {

                    			newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SignedConstant_2=ruleSignedConstant();

                    state._fsp--;


                    			current = this_SignedConstant_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalContract.g:4302:3: this_ConstantValue_3= ruleConstantValue
                    {

                    			newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConstantValue_3=ruleConstantValue();

                    state._fsp--;


                    			current = this_ConstantValue_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumAlt"


    // $ANTLR start "entryRuleAppliesToKeywords"
    // InternalContract.g:4314:1: entryRuleAppliesToKeywords returns [String current=null] : iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF ;
    public final String entryRuleAppliesToKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAppliesToKeywords = null;


        try {
            // InternalContract.g:4314:57: (iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF )
            // InternalContract.g:4315:2: iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF
            {
             newCompositeNode(grammarAccess.getAppliesToKeywordsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAppliesToKeywords=ruleAppliesToKeywords();

            state._fsp--;

             current =iv_ruleAppliesToKeywords.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAppliesToKeywords"


    // $ANTLR start "ruleAppliesToKeywords"
    // InternalContract.g:4321:1: ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'applies' kw= 'to' ) ;
    public final AntlrDatatypeRuleToken ruleAppliesToKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalContract.g:4327:2: ( (kw= 'applies' kw= 'to' ) )
            // InternalContract.g:4328:2: (kw= 'applies' kw= 'to' )
            {
            // InternalContract.g:4328:2: (kw= 'applies' kw= 'to' )
            // InternalContract.g:4329:3: kw= 'applies' kw= 'to'
            {
            kw=(Token)match(input,74,FOLLOW_81); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0());
            		
            kw=(Token)match(input,75,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAppliesToKeywords"


    // $ANTLR start "entryRuleInBindingKeywords"
    // InternalContract.g:4343:1: entryRuleInBindingKeywords returns [String current=null] : iv_ruleInBindingKeywords= ruleInBindingKeywords EOF ;
    public final String entryRuleInBindingKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInBindingKeywords = null;


        try {
            // InternalContract.g:4343:57: (iv_ruleInBindingKeywords= ruleInBindingKeywords EOF )
            // InternalContract.g:4344:2: iv_ruleInBindingKeywords= ruleInBindingKeywords EOF
            {
             newCompositeNode(grammarAccess.getInBindingKeywordsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInBindingKeywords=ruleInBindingKeywords();

            state._fsp--;

             current =iv_ruleInBindingKeywords.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInBindingKeywords"


    // $ANTLR start "ruleInBindingKeywords"
    // InternalContract.g:4350:1: ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' kw= 'binding' ) ;
    public final AntlrDatatypeRuleToken ruleInBindingKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalContract.g:4356:2: ( (kw= 'in' kw= 'binding' ) )
            // InternalContract.g:4357:2: (kw= 'in' kw= 'binding' )
            {
            // InternalContract.g:4357:2: (kw= 'in' kw= 'binding' )
            // InternalContract.g:4358:3: kw= 'in' kw= 'binding'
            {
            kw=(Token)match(input,76,FOLLOW_82); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getInKeyword_0());
            		
            kw=(Token)match(input,77,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInBindingKeywords"


    // $ANTLR start "entryRuleInModesKeywords"
    // InternalContract.g:4372:1: entryRuleInModesKeywords returns [String current=null] : iv_ruleInModesKeywords= ruleInModesKeywords EOF ;
    public final String entryRuleInModesKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInModesKeywords = null;


        try {
            // InternalContract.g:4372:55: (iv_ruleInModesKeywords= ruleInModesKeywords EOF )
            // InternalContract.g:4373:2: iv_ruleInModesKeywords= ruleInModesKeywords EOF
            {
             newCompositeNode(grammarAccess.getInModesKeywordsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInModesKeywords=ruleInModesKeywords();

            state._fsp--;

             current =iv_ruleInModesKeywords.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInModesKeywords"


    // $ANTLR start "ruleInModesKeywords"
    // InternalContract.g:4379:1: ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' kw= 'modes' ) ;
    public final AntlrDatatypeRuleToken ruleInModesKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalContract.g:4385:2: ( (kw= 'in' kw= 'modes' ) )
            // InternalContract.g:4386:2: (kw= 'in' kw= 'modes' )
            {
            // InternalContract.g:4386:2: (kw= 'in' kw= 'modes' )
            // InternalContract.g:4387:3: kw= 'in' kw= 'modes'
            {
            kw=(Token)match(input,76,FOLLOW_83); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getInKeyword_0());
            		
            kw=(Token)match(input,78,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getModesKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInModesKeywords"


    // $ANTLR start "entryRuleINTVALUE"
    // InternalContract.g:4401:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalContract.g:4401:48: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalContract.g:4402:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
             newCompositeNode(grammarAccess.getINTVALUERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;

             current =iv_ruleINTVALUE.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTVALUE"


    // $ANTLR start "ruleINTVALUE"
    // InternalContract.g:4408:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;


        	enterRule();

        try {
            // InternalContract.g:4414:2: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalContract.g:4415:2: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

            		current.merge(this_INTEGER_LIT_0);
            	

            		newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleINTVALUE"


    // $ANTLR start "entryRuleQPREF"
    // InternalContract.g:4425:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalContract.g:4425:45: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalContract.g:4426:2: iv_ruleQPREF= ruleQPREF EOF
            {
             newCompositeNode(grammarAccess.getQPREFRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;

             current =iv_ruleQPREF.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQPREF"


    // $ANTLR start "ruleQPREF"
    // InternalContract.g:4432:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalContract.g:4438:2: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // InternalContract.g:4439:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // InternalContract.g:4439:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // InternalContract.g:4440:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_84); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());
            		
            // InternalContract.g:4447:3: (kw= '::' this_ID_2= RULE_ID )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==60) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalContract.g:4448:4: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,60,FOLLOW_4); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0());
                    			
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    				current.merge(this_ID_2);
                    			

                    				newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQPREF"


    // $ANTLR start "entryRuleQCREF"
    // InternalContract.g:4465:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalContract.g:4465:45: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalContract.g:4466:2: iv_ruleQCREF= ruleQCREF EOF
            {
             newCompositeNode(grammarAccess.getQCREFRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;

             current =iv_ruleQCREF.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQCREF"


    // $ANTLR start "ruleQCREF"
    // InternalContract.g:4472:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalContract.g:4478:2: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // InternalContract.g:4479:2: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // InternalContract.g:4479:2: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // InternalContract.g:4480:3: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // InternalContract.g:4480:3: (this_ID_0= RULE_ID kw= '::' )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==RULE_ID) ) {
                    int LA83_1 = input.LA(2);

                    if ( (LA83_1==60) ) {
                        alt83=1;
                    }


                }


                switch (alt83) {
            	case 1 :
            	    // InternalContract.g:4481:4: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_63); 

            	    				current.merge(this_ID_0);
            	    			

            	    				newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0());
            	    			
            	    kw=(Token)match(input,60,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_85); 

            			current.merge(this_ID_2);
            		

            			newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());
            		
            // InternalContract.g:4501:3: (kw= '.' this_ID_4= RULE_ID )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==53) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalContract.g:4502:4: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,53,FOLLOW_4); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0());
                    			
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_2); 

                    				current.merge(this_ID_4);
                    			

                    				newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQCREF"


    // $ANTLR start "entryRuleSTAR"
    // InternalContract.g:4519:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalContract.g:4519:44: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalContract.g:4520:2: iv_ruleSTAR= ruleSTAR EOF
            {
             newCompositeNode(grammarAccess.getSTARRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;

             current =iv_ruleSTAR.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTAR"


    // $ANTLR start "ruleSTAR"
    // InternalContract.g:4526:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '*' ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalContract.g:4532:2: (kw= '*' )
            // InternalContract.g:4533:2: kw= '*'
            {
            kw=(Token)match(input,79,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTAR"


    // $ANTLR start "ruleLanguage"
    // InternalContract.g:4541:1: ruleLanguage returns [Enumerator current=null] : ( (enumLiteral_0= 'python' ) | (enumLiteral_1= 'java' ) | (enumLiteral_2= 'smt' ) ) ;
    public final Enumerator ruleLanguage() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalContract.g:4547:2: ( ( (enumLiteral_0= 'python' ) | (enumLiteral_1= 'java' ) | (enumLiteral_2= 'smt' ) ) )
            // InternalContract.g:4548:2: ( (enumLiteral_0= 'python' ) | (enumLiteral_1= 'java' ) | (enumLiteral_2= 'smt' ) )
            {
            // InternalContract.g:4548:2: ( (enumLiteral_0= 'python' ) | (enumLiteral_1= 'java' ) | (enumLiteral_2= 'smt' ) )
            int alt85=3;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt85=1;
                }
                break;
            case 81:
                {
                alt85=2;
                }
                break;
            case 82:
                {
                alt85=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalContract.g:4549:3: (enumLiteral_0= 'python' )
                    {
                    // InternalContract.g:4549:3: (enumLiteral_0= 'python' )
                    // InternalContract.g:4550:4: enumLiteral_0= 'python'
                    {
                    enumLiteral_0=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPYTHONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getPYTHONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:4557:3: (enumLiteral_1= 'java' )
                    {
                    // InternalContract.g:4557:3: (enumLiteral_1= 'java' )
                    // InternalContract.g:4558:4: enumLiteral_1= 'java'
                    {
                    enumLiteral_1=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getJAVAEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getJAVAEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalContract.g:4565:3: (enumLiteral_2= 'smt' )
                    {
                    // InternalContract.g:4565:3: (enumLiteral_2= 'smt' )
                    // InternalContract.g:4566:4: enumLiteral_2= 'smt'
                    {
                    enumLiteral_2=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSMTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLanguageAccess().getSMTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLanguage"

    // Delegated rules


    protected DFA67 dfa67 = new DFA67(this);
    static final String dfa_1s = "\25\uffff";
    static final String dfa_2s = "\10\uffff\1\17\1\21\1\23\3\uffff\1\17\1\uffff\1\21\3\uffff\1\23";
    static final String dfa_3s = "\1\4\5\uffff\4\4\1\34\3\uffff\1\34\1\uffff\1\34\1\uffff\1\4\1\uffff\1\34";
    static final String dfa_4s = "\1\107\5\uffff\2\14\3\114\3\uffff\1\114\1\uffff\1\114\1\uffff\1\4\1\uffff\1\114";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\5\uffff\1\11\1\12\1\6\1\uffff\1\7\1\uffff\1\10\1\uffff\1\13\1\uffff";
    static final String dfa_6s = "\25\uffff}>";
    static final String[] dfa_7s = {
            "\1\12\5\uffff\1\5\1\11\1\10\32\uffff\1\13\27\uffff\2\14\1\2\1\1\1\uffff\1\4\1\3\1\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\15\6\uffff\1\11\1\10",
            "\1\15\6\uffff\1\11\1\10",
            "\1\16\27\uffff\1\17\13\uffff\1\17\7\uffff\1\17\27\uffff\1\15\1\uffff\1\17\1\uffff\1\17",
            "\1\20\27\uffff\1\21\13\uffff\1\21\7\uffff\1\21\27\uffff\1\15\1\uffff\1\21\1\uffff\1\21",
            "\1\23\13\uffff\1\23\7\uffff\1\23\13\uffff\1\22\13\uffff\1\15\1\uffff\1\23\1\uffff\1\23",
            "",
            "",
            "",
            "\1\17\13\uffff\1\17\7\uffff\1\17\27\uffff\1\15\1\uffff\1\17\1\uffff\1\17",
            "",
            "\1\21\13\uffff\1\21\7\uffff\1\21\27\uffff\1\15\1\uffff\1\21\1\uffff\1\21",
            "",
            "\1\24",
            "",
            "\1\23\13\uffff\1\23\7\uffff\1\23\27\uffff\1\15\1\uffff\1\23\1\uffff\1\23"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "3144:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000021400200002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000EF800000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000FF000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000EF000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00008000FE000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000EE000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000FC0000E0L,0x0000000000070000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000004F82000E0L,0x0000000000070000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000E8000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000000000E0L,0x0000000000070000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000000E0000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000900000E0L,0x0000000000070000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000800010000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000012L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000004102000E2L,0x0000000000070000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000000100000E2L,0x0000000000070000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000002081000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000802090000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002080000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000488800000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000498000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000488000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000480000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000010400200000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000600080800000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000600090000010L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000600080000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x00004000900000E0L,0x0000000000070000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000400080000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000090000010L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0001010000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0310008000000010L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0300008000000010L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0060008000400002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0060000000400002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0310808010000010L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000100000000310L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x2000000100000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0xC000008000001C10L,0x00000000000000F7L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0001000010000000L,0x0000000000001400L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0001000010000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000008L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0xC000018000001C10L,0x00000000000000F7L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000108L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000001810L,0x00000000000000C0L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0020000000000002L});

}