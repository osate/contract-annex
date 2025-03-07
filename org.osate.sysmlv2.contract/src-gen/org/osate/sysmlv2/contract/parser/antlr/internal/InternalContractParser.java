package org.osate.sysmlv2.contract.parser.antlr.internal;

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
import org.osate.sysmlv2.contract.services.ContractGrammarAccess;



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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SSTRING", "RULE_STRING", "RULE_ISTRING_TEXT", "RULE_ISTRING_LEFT", "RULE_ISTRING_MIDDLE", "RULE_ISTRING_RIGHT", "RULE_IN_ISTRING", "RULE_SL_COMMENT", "'package'", "';'", "'contract'", "'{'", "'domains'", "'queries'", "'input'", "'assumptions'", "'guarantee'", "'invocation'", "'analysis'", "'}'", "'=>'", "'<=>'", "'argument'", "'implementation'", "'domain'", "'declarations'", "'and'", "'('", "','", "')'", "'or'", "'not'", "'verification'", "'plan'", "'component'", "':'", "'claims'", "'contracts'", "'val'", "'='", "'||'", "'&&'", "'!'", "'.'", "'<'", "'>'", "'#'", "'->'", "'self'", "'root'", "'::'", "'python'", "'java'", "'smt'", "'error0'", "'info0'"
    };
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
        	return "ContractLibrary";
       	}

       	@Override
       	protected ContractGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleContractLibrary"
    // InternalContract.g:88:1: entryRuleContractLibrary returns [EObject current=null] : iv_ruleContractLibrary= ruleContractLibrary EOF ;
    public final EObject entryRuleContractLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractLibrary = null;


        try {
            // InternalContract.g:88:56: (iv_ruleContractLibrary= ruleContractLibrary EOF )
            // InternalContract.g:89:2: iv_ruleContractLibrary= ruleContractLibrary EOF
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
    // InternalContract.g:95:1: ruleContractLibrary returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_contractElements_3_0= ruleContractElement ) )* ) ;
    public final EObject ruleContractLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_contractElements_3_0 = null;



        	enterRule();

        try {
            // InternalContract.g:101:2: ( (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_contractElements_3_0= ruleContractElement ) )* ) )
            // InternalContract.g:102:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_contractElements_3_0= ruleContractElement ) )* )
            {
            // InternalContract.g:102:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_contractElements_3_0= ruleContractElement ) )* )
            // InternalContract.g:103:3: otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ( (lv_contractElements_3_0= ruleContractElement ) )*
            {
            otherlv_0=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContractLibraryAccess().getPackageKeyword_0());
            		
            // InternalContract.g:107:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:108:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:108:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:109:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContractLibraryAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContractLibraryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.osate.sysmlv2.contract.Contract.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getContractLibraryAccess().getSemicolonKeyword_2());
            		
            // InternalContract.g:129:3: ( (lv_contractElements_3_0= ruleContractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15||LA1_0==27||LA1_0==29||LA1_0==37) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContract.g:130:4: (lv_contractElements_3_0= ruleContractElement )
            	    {
            	    // InternalContract.g:130:4: (lv_contractElements_3_0= ruleContractElement )
            	    // InternalContract.g:131:5: lv_contractElements_3_0= ruleContractElement
            	    {

            	    					newCompositeNode(grammarAccess.getContractLibraryAccess().getContractElementsContractElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_contractElements_3_0=ruleContractElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContractLibraryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"contractElements",
            	    						lv_contractElements_3_0,
            	    						"org.osate.sysmlv2.contract.Contract.ContractElement");
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
    // InternalContract.g:152:1: entryRuleContractElement returns [EObject current=null] : iv_ruleContractElement= ruleContractElement EOF ;
    public final EObject entryRuleContractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractElement = null;


        try {
            // InternalContract.g:152:56: (iv_ruleContractElement= ruleContractElement EOF )
            // InternalContract.g:153:2: iv_ruleContractElement= ruleContractElement EOF
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
    // InternalContract.g:159:1: ruleContractElement returns [EObject current=null] : (this_Implementation_0= ruleImplementation | this_Domain_1= ruleDomain | this_Argument_2= ruleArgument | this_Contract_3= ruleContract | this_VerificationPlan_4= ruleVerificationPlan ) ;
    public final EObject ruleContractElement() throws RecognitionException {
        EObject current = null;

        EObject this_Implementation_0 = null;

        EObject this_Domain_1 = null;

        EObject this_Argument_2 = null;

        EObject this_Contract_3 = null;

        EObject this_VerificationPlan_4 = null;



        	enterRule();

        try {
            // InternalContract.g:165:2: ( (this_Implementation_0= ruleImplementation | this_Domain_1= ruleDomain | this_Argument_2= ruleArgument | this_Contract_3= ruleContract | this_VerificationPlan_4= ruleVerificationPlan ) )
            // InternalContract.g:166:2: (this_Implementation_0= ruleImplementation | this_Domain_1= ruleDomain | this_Argument_2= ruleArgument | this_Contract_3= ruleContract | this_VerificationPlan_4= ruleVerificationPlan )
            {
            // InternalContract.g:166:2: (this_Implementation_0= ruleImplementation | this_Domain_1= ruleDomain | this_Argument_2= ruleArgument | this_Contract_3= ruleContract | this_VerificationPlan_4= ruleVerificationPlan )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 15:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_ID) ) {
                    alt2=4;
                }
                else if ( (LA2_1==28) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case 29:
                {
                alt2=2;
                }
                break;
            case 27:
                {
                alt2=3;
                }
                break;
            case 37:
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
                    // InternalContract.g:167:3: this_Implementation_0= ruleImplementation
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
                    // InternalContract.g:176:3: this_Domain_1= ruleDomain
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
                    // InternalContract.g:185:3: this_Argument_2= ruleArgument
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
                    // InternalContract.g:194:3: this_Contract_3= ruleContract
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
                    // InternalContract.g:203:3: this_VerificationPlan_4= ruleVerificationPlan
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
    // InternalContract.g:215:1: entryRuleContract returns [EObject current=null] : iv_ruleContract= ruleContract EOF ;
    public final EObject entryRuleContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContract = null;


        try {
            // InternalContract.g:215:49: (iv_ruleContract= ruleContract EOF )
            // InternalContract.g:216:2: iv_ruleContract= ruleContract EOF
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
    // InternalContract.g:222:1: ruleContract returns [EObject current=null] : (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )? (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )? (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )? (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )? ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )? otherlv_19= '}' ) ;
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
            // InternalContract.g:228:2: ( (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )? (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )? (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )? (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )? ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )? otherlv_19= '}' ) )
            // InternalContract.g:229:2: (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )? (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )? (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )? (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )? ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )? otherlv_19= '}' )
            {
            // InternalContract.g:229:2: (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )? (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )? (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )? (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )? ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )? otherlv_19= '}' )
            // InternalContract.g:230:3: otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )? (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )? (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )? (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )? ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )? otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContractAccess().getContractKeyword_0());
            		
            // InternalContract.g:234:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:235:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:235:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:236:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContractAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContractRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.osate.sysmlv2.contract.Contract.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getContractAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalContract.g:256:3: (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalContract.g:257:4: otherlv_3= 'domains' this_Domains_4= ruleDomains[$current]
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getContractAccess().getDomainsKeyword_3_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getContractRule());
                    				}
                    				newCompositeNode(grammarAccess.getContractAccess().getDomainsParserRuleCall_3_1());
                    			
                    pushFollow(FOLLOW_9);
                    this_Domains_4=ruleDomains(current);

                    state._fsp--;


                    				current = this_Domains_4;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:273:3: (otherlv_5= 'queries' this_Queries_6= ruleQueries[$current] )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalContract.g:274:4: otherlv_5= 'queries' this_Queries_6= ruleQueries[$current]
                    {
                    otherlv_5=(Token)match(input,18,FOLLOW_10); 

                    				newLeafNode(otherlv_5, grammarAccess.getContractAccess().getQueriesKeyword_4_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getContractRule());
                    				}
                    				newCompositeNode(grammarAccess.getContractAccess().getQueriesParserRuleCall_4_1());
                    			
                    pushFollow(FOLLOW_11);
                    this_Queries_6=ruleQueries(current);

                    state._fsp--;


                    				current = this_Queries_6;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:290:3: (otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalContract.g:291:4: otherlv_7= 'input' otherlv_8= 'assumptions' ( (lv_inputs_9_0= ruleInputAssumption ) )*
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_12); 

                    				newLeafNode(otherlv_7, grammarAccess.getContractAccess().getInputKeyword_5_0());
                    			
                    otherlv_8=(Token)match(input,20,FOLLOW_13); 

                    				newLeafNode(otherlv_8, grammarAccess.getContractAccess().getAssumptionsKeyword_5_1());
                    			
                    // InternalContract.g:299:4: ( (lv_inputs_9_0= ruleInputAssumption ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_SSTRING||(LA5_0>=RULE_ISTRING_TEXT && LA5_0<=RULE_ISTRING_LEFT)||LA5_0==14||(LA5_0>=56 && LA5_0<=58)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalContract.g:300:5: (lv_inputs_9_0= ruleInputAssumption )
                    	    {
                    	    // InternalContract.g:300:5: (lv_inputs_9_0= ruleInputAssumption )
                    	    // InternalContract.g:301:6: lv_inputs_9_0= ruleInputAssumption
                    	    {

                    	    						newCompositeNode(grammarAccess.getContractAccess().getInputsInputAssumptionParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
                    	    lv_inputs_9_0=ruleInputAssumption();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getContractRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"inputs",
                    	    							lv_inputs_9_0,
                    	    							"org.osate.sysmlv2.contract.Contract.InputAssumption");
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

            // InternalContract.g:319:3: (otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current] )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalContract.g:320:4: otherlv_10= 'assumptions' this_Assumptions_11= ruleAssumptions[$current]
                    {
                    otherlv_10=(Token)match(input,20,FOLLOW_14); 

                    				newLeafNode(otherlv_10, grammarAccess.getContractAccess().getAssumptionsKeyword_6_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getContractRule());
                    				}
                    				newCompositeNode(grammarAccess.getContractAccess().getAssumptionsParserRuleCall_6_1());
                    			
                    pushFollow(FOLLOW_15);
                    this_Assumptions_11=ruleAssumptions(current);

                    state._fsp--;


                    				current = this_Assumptions_11;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:336:3: (otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalContract.g:337:4: otherlv_12= 'guarantee' this_Exact_13= ruleExact[$current] ( (lv_guarantee_14_0= ruleGuarantee ) ) otherlv_15= ';'
                    {
                    otherlv_12=(Token)match(input,21,FOLLOW_16); 

                    				newLeafNode(otherlv_12, grammarAccess.getContractAccess().getGuaranteeKeyword_7_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getContractRule());
                    				}
                    				newCompositeNode(grammarAccess.getContractAccess().getExactParserRuleCall_7_1());
                    			
                    pushFollow(FOLLOW_17);
                    this_Exact_13=ruleExact(current);

                    state._fsp--;


                    				current = this_Exact_13;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalContract.g:352:4: ( (lv_guarantee_14_0= ruleGuarantee ) )
                    // InternalContract.g:353:5: (lv_guarantee_14_0= ruleGuarantee )
                    {
                    // InternalContract.g:353:5: (lv_guarantee_14_0= ruleGuarantee )
                    // InternalContract.g:354:6: lv_guarantee_14_0= ruleGuarantee
                    {

                    						newCompositeNode(grammarAccess.getContractAccess().getGuaranteeGuaranteeParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_guarantee_14_0=ruleGuarantee();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContractRule());
                    						}
                    						set(
                    							current,
                    							"guarantee",
                    							lv_guarantee_14_0,
                    							"org.osate.sysmlv2.contract.Contract.Guarantee");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,14,FOLLOW_18); 

                    				newLeafNode(otherlv_15, grammarAccess.getContractAccess().getSemicolonKeyword_7_3());
                    			

                    }
                    break;

            }

            // InternalContract.g:376:3: ( (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current] )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=22 && LA10_0<=23)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalContract.g:377:4: (otherlv_16= 'invocation' | otherlv_17= 'analysis' ) this_Analyses_18= ruleAnalyses[$current]
                    {
                    // InternalContract.g:377:4: (otherlv_16= 'invocation' | otherlv_17= 'analysis' )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==22) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==23) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalContract.g:378:5: otherlv_16= 'invocation'
                            {
                            otherlv_16=(Token)match(input,22,FOLLOW_19); 

                            					newLeafNode(otherlv_16, grammarAccess.getContractAccess().getInvocationKeyword_8_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalContract.g:383:5: otherlv_17= 'analysis'
                            {
                            otherlv_17=(Token)match(input,23,FOLLOW_19); 

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

            otherlv_19=(Token)match(input,24,FOLLOW_2); 

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
    // InternalContract.g:409:1: ruleExact[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '=>' | ( (lv_exact_1_0= '<=>' ) ) ) ;
    public final EObject ruleExact(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token lv_exact_1_0=null;


        	enterRule();

        try {
            // InternalContract.g:415:2: ( (otherlv_0= '=>' | ( (lv_exact_1_0= '<=>' ) ) ) )
            // InternalContract.g:416:2: (otherlv_0= '=>' | ( (lv_exact_1_0= '<=>' ) ) )
            {
            // InternalContract.g:416:2: (otherlv_0= '=>' | ( (lv_exact_1_0= '<=>' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            else if ( (LA11_0==26) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalContract.g:417:3: otherlv_0= '=>'
                    {
                    otherlv_0=(Token)match(input,25,FOLLOW_2); 

                    			newLeafNode(otherlv_0, grammarAccess.getExactAccess().getEqualsSignGreaterThanSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalContract.g:422:3: ( (lv_exact_1_0= '<=>' ) )
                    {
                    // InternalContract.g:422:3: ( (lv_exact_1_0= '<=>' ) )
                    // InternalContract.g:423:4: (lv_exact_1_0= '<=>' )
                    {
                    // InternalContract.g:423:4: (lv_exact_1_0= '<=>' )
                    // InternalContract.g:424:5: lv_exact_1_0= '<=>'
                    {
                    lv_exact_1_0=(Token)match(input,26,FOLLOW_2); 

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
    // InternalContract.g:441:1: ruleQueries[EObject in_current] returns [EObject current=in_current] : ( ( (lv_queries_0_0= ruleQuery ) )? otherlv_1= ';' )* ;
    public final EObject ruleQueries(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_queries_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:447:2: ( ( ( (lv_queries_0_0= ruleQuery ) )? otherlv_1= ';' )* )
            // InternalContract.g:448:2: ( ( (lv_queries_0_0= ruleQuery ) )? otherlv_1= ';' )*
            {
            // InternalContract.g:448:2: ( ( (lv_queries_0_0= ruleQuery ) )? otherlv_1= ';' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==14||LA13_0==43) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalContract.g:449:3: ( (lv_queries_0_0= ruleQuery ) )? otherlv_1= ';'
            	    {
            	    // InternalContract.g:449:3: ( (lv_queries_0_0= ruleQuery ) )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==43) ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // InternalContract.g:450:4: (lv_queries_0_0= ruleQuery )
            	            {
            	            // InternalContract.g:450:4: (lv_queries_0_0= ruleQuery )
            	            // InternalContract.g:451:5: lv_queries_0_0= ruleQuery
            	            {

            	            					newCompositeNode(grammarAccess.getQueriesAccess().getQueriesQueryParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_4);
            	            lv_queries_0_0=ruleQuery();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getQueriesRule());
            	            					}
            	            					add(
            	            						current,
            	            						"queries",
            	            						lv_queries_0_0,
            	            						"org.osate.sysmlv2.contract.Contract.Query");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_1=(Token)match(input,14,FOLLOW_21); 

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
    // InternalContract.g:477:1: ruleDomains[EObject in_current] returns [EObject current=in_current] : ( ( ( ruleQPREF ) )? otherlv_1= ';' )* ;
    public final EObject ruleDomains(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalContract.g:483:2: ( ( ( ( ruleQPREF ) )? otherlv_1= ';' )* )
            // InternalContract.g:484:2: ( ( ( ruleQPREF ) )? otherlv_1= ';' )*
            {
            // InternalContract.g:484:2: ( ( ( ruleQPREF ) )? otherlv_1= ';' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID||LA15_0==14) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalContract.g:485:3: ( ( ruleQPREF ) )? otherlv_1= ';'
            	    {
            	    // InternalContract.g:485:3: ( ( ruleQPREF ) )?
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==RULE_ID) ) {
            	        alt14=1;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // InternalContract.g:486:4: ( ruleQPREF )
            	            {
            	            // InternalContract.g:486:4: ( ruleQPREF )
            	            // InternalContract.g:487:5: ruleQPREF
            	            {

            	            					if (current==null) {
            	            						current = createModelElement(grammarAccess.getDomainsRule());
            	            					}
            	            				

            	            					newCompositeNode(grammarAccess.getDomainsAccess().getDomainsDomainCrossReference_0_0());
            	            				
            	            pushFollow(FOLLOW_4);
            	            ruleQPREF();

            	            state._fsp--;


            	            					afterParserOrEnumRuleCall();
            	            				

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_1=(Token)match(input,14,FOLLOW_22); 

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
    // InternalContract.g:510:1: ruleAssumptions[EObject in_current] returns [EObject current=in_current] : ( ( (lv_assumptions_0_0= ruleAssumptionElement ) )? otherlv_1= ';' )* ;
    public final EObject ruleAssumptions(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_assumptions_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:516:2: ( ( ( (lv_assumptions_0_0= ruleAssumptionElement ) )? otherlv_1= ';' )* )
            // InternalContract.g:517:2: ( ( (lv_assumptions_0_0= ruleAssumptionElement ) )? otherlv_1= ';' )*
            {
            // InternalContract.g:517:2: ( ( (lv_assumptions_0_0= ruleAssumptionElement ) )? otherlv_1= ';' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_SSTRING||(LA17_0>=RULE_ISTRING_TEXT && LA17_0<=RULE_ISTRING_LEFT)||(LA17_0>=14 && LA17_0<=15)||LA17_0==27||(LA17_0>=56 && LA17_0<=58)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalContract.g:518:3: ( (lv_assumptions_0_0= ruleAssumptionElement ) )? otherlv_1= ';'
            	    {
            	    // InternalContract.g:518:3: ( (lv_assumptions_0_0= ruleAssumptionElement ) )?
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0==RULE_SSTRING||(LA16_0>=RULE_ISTRING_TEXT && LA16_0<=RULE_ISTRING_LEFT)||LA16_0==15||LA16_0==27||(LA16_0>=56 && LA16_0<=58)) ) {
            	        alt16=1;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // InternalContract.g:519:4: (lv_assumptions_0_0= ruleAssumptionElement )
            	            {
            	            // InternalContract.g:519:4: (lv_assumptions_0_0= ruleAssumptionElement )
            	            // InternalContract.g:520:5: lv_assumptions_0_0= ruleAssumptionElement
            	            {

            	            					newCompositeNode(grammarAccess.getAssumptionsAccess().getAssumptionsAssumptionElementParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_4);
            	            lv_assumptions_0_0=ruleAssumptionElement();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getAssumptionsRule());
            	            					}
            	            					add(
            	            						current,
            	            						"assumptions",
            	            						lv_assumptions_0_0,
            	            						"org.osate.sysmlv2.contract.Contract.AssumptionElement");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_1=(Token)match(input,14,FOLLOW_23); 

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
    // InternalContract.g:546:1: ruleAnalyses[EObject in_current] returns [EObject current=in_current] : ( ( (lv_analyses_0_0= ruleAnalysis ) )? otherlv_1= ';' )* ;
    public final EObject ruleAnalyses(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_analyses_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:552:2: ( ( ( (lv_analyses_0_0= ruleAnalysis ) )? otherlv_1= ';' )* )
            // InternalContract.g:553:2: ( ( (lv_analyses_0_0= ruleAnalysis ) )? otherlv_1= ';' )*
            {
            // InternalContract.g:553:2: ( ( (lv_analyses_0_0= ruleAnalysis ) )? otherlv_1= ';' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_SSTRING||(LA19_0>=RULE_ISTRING_TEXT && LA19_0<=RULE_ISTRING_LEFT)||LA19_0==14||(LA19_0>=56 && LA19_0<=58)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalContract.g:554:3: ( (lv_analyses_0_0= ruleAnalysis ) )? otherlv_1= ';'
            	    {
            	    // InternalContract.g:554:3: ( (lv_analyses_0_0= ruleAnalysis ) )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==RULE_SSTRING||(LA18_0>=RULE_ISTRING_TEXT && LA18_0<=RULE_ISTRING_LEFT)||(LA18_0>=56 && LA18_0<=58)) ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // InternalContract.g:555:4: (lv_analyses_0_0= ruleAnalysis )
            	            {
            	            // InternalContract.g:555:4: (lv_analyses_0_0= ruleAnalysis )
            	            // InternalContract.g:556:5: lv_analyses_0_0= ruleAnalysis
            	            {

            	            					newCompositeNode(grammarAccess.getAnalysesAccess().getAnalysesAnalysisParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_4);
            	            lv_analyses_0_0=ruleAnalysis();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getAnalysesRule());
            	            					}
            	            					add(
            	            						current,
            	            						"analyses",
            	            						lv_analyses_0_0,
            	            						"org.osate.sysmlv2.contract.Contract.Analysis");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_1=(Token)match(input,14,FOLLOW_24); 

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
    // InternalContract.g:581:1: entryRuleInputAssumption returns [EObject current=null] : iv_ruleInputAssumption= ruleInputAssumption EOF ;
    public final EObject entryRuleInputAssumption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputAssumption = null;


        try {
            // InternalContract.g:581:56: (iv_ruleInputAssumption= ruleInputAssumption EOF )
            // InternalContract.g:582:2: iv_ruleInputAssumption= ruleInputAssumption EOF
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
    // InternalContract.g:588:1: ruleInputAssumption returns [EObject current=null] : ( () ( (lv_code_1_0= ruleSource ) )? otherlv_2= ';' ) ;
    public final EObject ruleInputAssumption() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_code_1_0 = null;



        	enterRule();

        try {
            // InternalContract.g:594:2: ( ( () ( (lv_code_1_0= ruleSource ) )? otherlv_2= ';' ) )
            // InternalContract.g:595:2: ( () ( (lv_code_1_0= ruleSource ) )? otherlv_2= ';' )
            {
            // InternalContract.g:595:2: ( () ( (lv_code_1_0= ruleSource ) )? otherlv_2= ';' )
            // InternalContract.g:596:3: () ( (lv_code_1_0= ruleSource ) )? otherlv_2= ';'
            {
            // InternalContract.g:596:3: ()
            // InternalContract.g:597:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInputAssumptionAccess().getInputAssumptionAction_0(),
            					current);
            			

            }

            // InternalContract.g:603:3: ( (lv_code_1_0= ruleSource ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_SSTRING||(LA20_0>=RULE_ISTRING_TEXT && LA20_0<=RULE_ISTRING_LEFT)||(LA20_0>=56 && LA20_0<=58)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalContract.g:604:4: (lv_code_1_0= ruleSource )
                    {
                    // InternalContract.g:604:4: (lv_code_1_0= ruleSource )
                    // InternalContract.g:605:5: lv_code_1_0= ruleSource
                    {

                    					newCompositeNode(grammarAccess.getInputAssumptionAccess().getCodeSourceParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_code_1_0=ruleSource();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInputAssumptionRule());
                    					}
                    					set(
                    						current,
                    						"code",
                    						lv_code_1_0,
                    						"org.osate.sysmlv2.contract.Contract.Source");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,14,FOLLOW_2); 

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
    // InternalContract.g:630:1: entryRuleAssumptionElement returns [EObject current=null] : iv_ruleAssumptionElement= ruleAssumptionElement EOF ;
    public final EObject entryRuleAssumptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssumptionElement = null;


        try {
            // InternalContract.g:630:58: (iv_ruleAssumptionElement= ruleAssumptionElement EOF )
            // InternalContract.g:631:2: iv_ruleAssumptionElement= ruleAssumptionElement EOF
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
    // InternalContract.g:637:1: ruleAssumptionElement returns [EObject current=null] : ( ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) ) | ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) ) | ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? ) ) ;
    public final EObject ruleAssumptionElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_code_7_0 = null;

        EObject this_Exact_8 = null;

        EObject lv_guarantee_9_0 = null;



        	enterRule();

        try {
            // InternalContract.g:643:2: ( ( ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) ) | ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) ) | ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? ) ) )
            // InternalContract.g:644:2: ( ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) ) | ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) ) | ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? ) )
            {
            // InternalContract.g:644:2: ( ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) ) | ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) ) | ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt22=1;
                }
                break;
            case 27:
                {
                alt22=2;
                }
                break;
            case RULE_SSTRING:
            case RULE_ISTRING_TEXT:
            case RULE_ISTRING_LEFT:
            case 56:
            case 57:
            case 58:
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
                    // InternalContract.g:645:3: ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) )
                    {
                    // InternalContract.g:645:3: ( () otherlv_1= 'contract' ( ( ruleQPREF ) ) )
                    // InternalContract.g:646:4: () otherlv_1= 'contract' ( ( ruleQPREF ) )
                    {
                    // InternalContract.g:646:4: ()
                    // InternalContract.g:647:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAssumptionElementAccess().getContractAssumptionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getAssumptionElementAccess().getContractKeyword_0_1());
                    			
                    // InternalContract.g:657:4: ( ( ruleQPREF ) )
                    // InternalContract.g:658:5: ( ruleQPREF )
                    {
                    // InternalContract.g:658:5: ( ruleQPREF )
                    // InternalContract.g:659:6: ruleQPREF
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
                    // InternalContract.g:675:3: ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) )
                    {
                    // InternalContract.g:675:3: ( () otherlv_4= 'argument' ( ( ruleQPREF ) ) )
                    // InternalContract.g:676:4: () otherlv_4= 'argument' ( ( ruleQPREF ) )
                    {
                    // InternalContract.g:676:4: ()
                    // InternalContract.g:677:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAssumptionElementAccess().getArgumentAssumptionAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_4=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getAssumptionElementAccess().getArgumentKeyword_1_1());
                    			
                    // InternalContract.g:687:4: ( ( ruleQPREF ) )
                    // InternalContract.g:688:5: ( ruleQPREF )
                    {
                    // InternalContract.g:688:5: ( ruleQPREF )
                    // InternalContract.g:689:6: ruleQPREF
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
                    // InternalContract.g:705:3: ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? )
                    {
                    // InternalContract.g:705:3: ( () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )? )
                    // InternalContract.g:706:4: () ( (lv_code_7_0= ruleSource ) ) (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )?
                    {
                    // InternalContract.g:706:4: ()
                    // InternalContract.g:707:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAssumptionElementAccess().getCodeAssumptionAction_2_0(),
                    						current);
                    				

                    }

                    // InternalContract.g:713:4: ( (lv_code_7_0= ruleSource ) )
                    // InternalContract.g:714:5: (lv_code_7_0= ruleSource )
                    {
                    // InternalContract.g:714:5: (lv_code_7_0= ruleSource )
                    // InternalContract.g:715:6: lv_code_7_0= ruleSource
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
                    							"org.osate.sysmlv2.contract.Contract.Source");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:732:4: (this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=25 && LA21_0<=26)) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalContract.g:733:5: this_Exact_8= ruleExact[$current] ( (lv_guarantee_9_0= ruleGuarantee ) )
                            {

                            					if (current==null) {
                            						current = createModelElement(grammarAccess.getAssumptionElementRule());
                            					}
                            					newCompositeNode(grammarAccess.getAssumptionElementAccess().getExactParserRuleCall_2_2_0());
                            				
                            pushFollow(FOLLOW_17);
                            this_Exact_8=ruleExact(current);

                            state._fsp--;


                            					current = this_Exact_8;
                            					afterParserOrEnumRuleCall();
                            				
                            // InternalContract.g:744:5: ( (lv_guarantee_9_0= ruleGuarantee ) )
                            // InternalContract.g:745:6: (lv_guarantee_9_0= ruleGuarantee )
                            {
                            // InternalContract.g:745:6: (lv_guarantee_9_0= ruleGuarantee )
                            // InternalContract.g:746:7: lv_guarantee_9_0= ruleGuarantee
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
                            								"org.osate.sysmlv2.contract.Contract.Guarantee");
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
    // InternalContract.g:769:1: entryRuleGuarantee returns [EObject current=null] : iv_ruleGuarantee= ruleGuarantee EOF ;
    public final EObject entryRuleGuarantee() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuarantee = null;


        try {
            // InternalContract.g:769:50: (iv_ruleGuarantee= ruleGuarantee EOF )
            // InternalContract.g:770:2: iv_ruleGuarantee= ruleGuarantee EOF
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
    // InternalContract.g:776:1: ruleGuarantee returns [EObject current=null] : ( (lv_code_0_0= ruleSource ) ) ;
    public final EObject ruleGuarantee() throws RecognitionException {
        EObject current = null;

        EObject lv_code_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:782:2: ( ( (lv_code_0_0= ruleSource ) ) )
            // InternalContract.g:783:2: ( (lv_code_0_0= ruleSource ) )
            {
            // InternalContract.g:783:2: ( (lv_code_0_0= ruleSource ) )
            // InternalContract.g:784:3: (lv_code_0_0= ruleSource )
            {
            // InternalContract.g:784:3: (lv_code_0_0= ruleSource )
            // InternalContract.g:785:4: lv_code_0_0= ruleSource
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
            					"org.osate.sysmlv2.contract.Contract.Source");
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
    // InternalContract.g:805:1: entryRuleAnalysis returns [EObject current=null] : iv_ruleAnalysis= ruleAnalysis EOF ;
    public final EObject entryRuleAnalysis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnalysis = null;


        try {
            // InternalContract.g:805:49: (iv_ruleAnalysis= ruleAnalysis EOF )
            // InternalContract.g:806:2: iv_ruleAnalysis= ruleAnalysis EOF
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
    // InternalContract.g:812:1: ruleAnalysis returns [EObject current=null] : ( (lv_code_0_0= ruleSource ) ) ;
    public final EObject ruleAnalysis() throws RecognitionException {
        EObject current = null;

        EObject lv_code_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:818:2: ( ( (lv_code_0_0= ruleSource ) ) )
            // InternalContract.g:819:2: ( (lv_code_0_0= ruleSource ) )
            {
            // InternalContract.g:819:2: ( (lv_code_0_0= ruleSource ) )
            // InternalContract.g:820:3: (lv_code_0_0= ruleSource )
            {
            // InternalContract.g:820:3: (lv_code_0_0= ruleSource )
            // InternalContract.g:821:4: lv_code_0_0= ruleSource
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
            					"org.osate.sysmlv2.contract.Contract.Source");
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
    // InternalContract.g:841:1: entryRuleSource returns [EObject current=null] : iv_ruleSource= ruleSource EOF ;
    public final EObject entryRuleSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSource = null;


        try {
            // InternalContract.g:841:47: (iv_ruleSource= ruleSource EOF )
            // InternalContract.g:842:2: iv_ruleSource= ruleSource EOF
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
    // InternalContract.g:848:1: ruleSource returns [EObject current=null] : ( ( (lv_language_0_0= ruleLanguage ) )? ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) ) ) ;
    public final EObject ruleSource() throws RecognitionException {
        EObject current = null;

        Token lv_source_1_0=null;
        Enumerator lv_language_0_0 = null;

        EObject lv_inter_2_0 = null;



        	enterRule();

        try {
            // InternalContract.g:854:2: ( ( ( (lv_language_0_0= ruleLanguage ) )? ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) ) ) )
            // InternalContract.g:855:2: ( ( (lv_language_0_0= ruleLanguage ) )? ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) ) )
            {
            // InternalContract.g:855:2: ( ( (lv_language_0_0= ruleLanguage ) )? ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) ) )
            // InternalContract.g:856:3: ( (lv_language_0_0= ruleLanguage ) )? ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) )
            {
            // InternalContract.g:856:3: ( (lv_language_0_0= ruleLanguage ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=56 && LA23_0<=58)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalContract.g:857:4: (lv_language_0_0= ruleLanguage )
                    {
                    // InternalContract.g:857:4: (lv_language_0_0= ruleLanguage )
                    // InternalContract.g:858:5: lv_language_0_0= ruleLanguage
                    {

                    					newCompositeNode(grammarAccess.getSourceAccess().getLanguageLanguageEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_17);
                    lv_language_0_0=ruleLanguage();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSourceRule());
                    					}
                    					set(
                    						current,
                    						"language",
                    						lv_language_0_0,
                    						"org.osate.sysmlv2.contract.Contract.Language");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalContract.g:875:3: ( ( (lv_source_1_0= RULE_SSTRING ) ) | ( (lv_inter_2_0= ruleIString ) ) )
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
                    // InternalContract.g:876:4: ( (lv_source_1_0= RULE_SSTRING ) )
                    {
                    // InternalContract.g:876:4: ( (lv_source_1_0= RULE_SSTRING ) )
                    // InternalContract.g:877:5: (lv_source_1_0= RULE_SSTRING )
                    {
                    // InternalContract.g:877:5: (lv_source_1_0= RULE_SSTRING )
                    // InternalContract.g:878:6: lv_source_1_0= RULE_SSTRING
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
                    							"org.osate.sysmlv2.contract.Contract.SSTRING");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:895:4: ( (lv_inter_2_0= ruleIString ) )
                    {
                    // InternalContract.g:895:4: ( (lv_inter_2_0= ruleIString ) )
                    // InternalContract.g:896:5: (lv_inter_2_0= ruleIString )
                    {
                    // InternalContract.g:896:5: (lv_inter_2_0= ruleIString )
                    // InternalContract.g:897:6: lv_inter_2_0= ruleIString
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
                    							"org.osate.sysmlv2.contract.Contract.IString");
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
    // InternalContract.g:919:1: entryRuleImplementation returns [EObject current=null] : iv_ruleImplementation= ruleImplementation EOF ;
    public final EObject entryRuleImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplementation = null;


        try {
            // InternalContract.g:919:55: (iv_ruleImplementation= ruleImplementation EOF )
            // InternalContract.g:920:2: iv_ruleImplementation= ruleImplementation EOF
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
    // InternalContract.g:926:1: ruleImplementation returns [EObject current=null] : (otherlv_0= 'contract' otherlv_1= 'implementation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_code_4_0= ruleSource ) ) otherlv_5= '}' ) ;
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
            // InternalContract.g:932:2: ( (otherlv_0= 'contract' otherlv_1= 'implementation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_code_4_0= ruleSource ) ) otherlv_5= '}' ) )
            // InternalContract.g:933:2: (otherlv_0= 'contract' otherlv_1= 'implementation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_code_4_0= ruleSource ) ) otherlv_5= '}' )
            {
            // InternalContract.g:933:2: (otherlv_0= 'contract' otherlv_1= 'implementation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_code_4_0= ruleSource ) ) otherlv_5= '}' )
            // InternalContract.g:934:3: otherlv_0= 'contract' otherlv_1= 'implementation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_code_4_0= ruleSource ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getImplementationAccess().getContractKeyword_0());
            		
            otherlv_1=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getImplementationAccess().getImplementationKeyword_1());
            		
            // InternalContract.g:942:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalContract.g:943:4: (lv_name_2_0= RULE_ID )
            {
            // InternalContract.g:943:4: (lv_name_2_0= RULE_ID )
            // InternalContract.g:944:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_2_0, grammarAccess.getImplementationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImplementationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.osate.sysmlv2.contract.Contract.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_17); 

            			newLeafNode(otherlv_3, grammarAccess.getImplementationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalContract.g:964:3: ( (lv_code_4_0= ruleSource ) )
            // InternalContract.g:965:4: (lv_code_4_0= ruleSource )
            {
            // InternalContract.g:965:4: (lv_code_4_0= ruleSource )
            // InternalContract.g:966:5: lv_code_4_0= ruleSource
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
            						"org.osate.sysmlv2.contract.Contract.Source");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,24,FOLLOW_2); 

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
    // InternalContract.g:991:1: entryRuleDomain returns [EObject current=null] : iv_ruleDomain= ruleDomain EOF ;
    public final EObject entryRuleDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomain = null;


        try {
            // InternalContract.g:991:47: (iv_ruleDomain= ruleDomain EOF )
            // InternalContract.g:992:2: iv_ruleDomain= ruleDomain EOF
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
    // InternalContract.g:998:1: ruleDomain returns [EObject current=null] : (otherlv_0= 'domain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )? (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )? otherlv_7= '}' ) ;
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
            // InternalContract.g:1004:2: ( (otherlv_0= 'domain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )? (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )? otherlv_7= '}' ) )
            // InternalContract.g:1005:2: (otherlv_0= 'domain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )? (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )? otherlv_7= '}' )
            {
            // InternalContract.g:1005:2: (otherlv_0= 'domain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )? (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )? otherlv_7= '}' )
            // InternalContract.g:1006:3: otherlv_0= 'domain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )? (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDomainAccess().getDomainKeyword_0());
            		
            // InternalContract.g:1010:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:1011:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:1011:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:1012:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDomainAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDomainRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.osate.sysmlv2.contract.Contract.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getDomainAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalContract.g:1032:3: (otherlv_3= 'queries' this_Queries_4= ruleQueries[$current] )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==18) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalContract.g:1033:4: otherlv_3= 'queries' this_Queries_4= ruleQueries[$current]
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_28); 

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

            // InternalContract.g:1049:3: (otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==30) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalContract.g:1050:4: otherlv_5= 'declarations' ( (lv_code_6_0= ruleSource ) )
                    {
                    otherlv_5=(Token)match(input,30,FOLLOW_17); 

                    				newLeafNode(otherlv_5, grammarAccess.getDomainAccess().getDeclarationsKeyword_4_0());
                    			
                    // InternalContract.g:1054:4: ( (lv_code_6_0= ruleSource ) )
                    // InternalContract.g:1055:5: (lv_code_6_0= ruleSource )
                    {
                    // InternalContract.g:1055:5: (lv_code_6_0= ruleSource )
                    // InternalContract.g:1056:6: lv_code_6_0= ruleSource
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
                    							"org.osate.sysmlv2.contract.Contract.Source");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,24,FOLLOW_2); 

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
    // InternalContract.g:1082:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalContract.g:1082:49: (iv_ruleArgument= ruleArgument EOF )
            // InternalContract.g:1083:2: iv_ruleArgument= ruleArgument EOF
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
    // InternalContract.g:1089:1: ruleArgument returns [EObject current=null] : (otherlv_0= 'argument' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )? (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) otherlv_11= ';' )? otherlv_12= '}' ) ;
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
        Token otherlv_12=null;
        EObject this_Domains_4 = null;

        EObject this_Exact_6 = null;

        EObject lv_guarantee_7_0 = null;

        EObject lv_argumentExpression_10_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1095:2: ( (otherlv_0= 'argument' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )? (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) otherlv_11= ';' )? otherlv_12= '}' ) )
            // InternalContract.g:1096:2: (otherlv_0= 'argument' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )? (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) otherlv_11= ';' )? otherlv_12= '}' )
            {
            // InternalContract.g:1096:2: (otherlv_0= 'argument' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )? (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) otherlv_11= ';' )? otherlv_12= '}' )
            // InternalContract.g:1097:3: otherlv_0= 'argument' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )? (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )? (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) otherlv_11= ';' )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getArgumentAccess().getArgumentKeyword_0());
            		
            // InternalContract.g:1101:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:1102:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:1102:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:1103:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArgumentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.osate.sysmlv2.contract.Contract.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getArgumentAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalContract.g:1123:3: (otherlv_3= 'domains' this_Domains_4= ruleDomains[$current] )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalContract.g:1124:4: otherlv_3= 'domains' this_Domains_4= ruleDomains[$current]
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_31); 

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

            // InternalContract.g:1140:3: (otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==21) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalContract.g:1141:4: otherlv_5= 'guarantee' this_Exact_6= ruleExact[$current] ( (lv_guarantee_7_0= ruleGuarantee ) ) otherlv_8= ';'
                    {
                    otherlv_5=(Token)match(input,21,FOLLOW_16); 

                    				newLeafNode(otherlv_5, grammarAccess.getArgumentAccess().getGuaranteeKeyword_4_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getArgumentRule());
                    				}
                    				newCompositeNode(grammarAccess.getArgumentAccess().getExactParserRuleCall_4_1());
                    			
                    pushFollow(FOLLOW_17);
                    this_Exact_6=ruleExact(current);

                    state._fsp--;


                    				current = this_Exact_6;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalContract.g:1156:4: ( (lv_guarantee_7_0= ruleGuarantee ) )
                    // InternalContract.g:1157:5: (lv_guarantee_7_0= ruleGuarantee )
                    {
                    // InternalContract.g:1157:5: (lv_guarantee_7_0= ruleGuarantee )
                    // InternalContract.g:1158:6: lv_guarantee_7_0= ruleGuarantee
                    {

                    						newCompositeNode(grammarAccess.getArgumentAccess().getGuaranteeGuaranteeParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_guarantee_7_0=ruleGuarantee();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArgumentRule());
                    						}
                    						set(
                    							current,
                    							"guarantee",
                    							lv_guarantee_7_0,
                    							"org.osate.sysmlv2.contract.Contract.Guarantee");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,14,FOLLOW_33); 

                    				newLeafNode(otherlv_8, grammarAccess.getArgumentAccess().getSemicolonKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalContract.g:1180:3: (otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) otherlv_11= ';' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==27) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalContract.g:1181:4: otherlv_9= 'argument' ( (lv_argumentExpression_10_0= ruleArgumentExpression ) ) otherlv_11= ';'
                    {
                    otherlv_9=(Token)match(input,27,FOLLOW_34); 

                    				newLeafNode(otherlv_9, grammarAccess.getArgumentAccess().getArgumentKeyword_5_0());
                    			
                    // InternalContract.g:1185:4: ( (lv_argumentExpression_10_0= ruleArgumentExpression ) )
                    // InternalContract.g:1186:5: (lv_argumentExpression_10_0= ruleArgumentExpression )
                    {
                    // InternalContract.g:1186:5: (lv_argumentExpression_10_0= ruleArgumentExpression )
                    // InternalContract.g:1187:6: lv_argumentExpression_10_0= ruleArgumentExpression
                    {

                    						newCompositeNode(grammarAccess.getArgumentAccess().getArgumentExpressionArgumentExpressionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_argumentExpression_10_0=ruleArgumentExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArgumentRule());
                    						}
                    						set(
                    							current,
                    							"argumentExpression",
                    							lv_argumentExpression_10_0,
                    							"org.osate.sysmlv2.contract.Contract.ArgumentExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,14,FOLLOW_20); 

                    				newLeafNode(otherlv_11, grammarAccess.getArgumentAccess().getSemicolonKeyword_5_2());
                    			

                    }
                    break;

            }

            otherlv_12=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getArgumentAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalContract.g:1217:1: entryRuleArgumentExpression returns [EObject current=null] : iv_ruleArgumentExpression= ruleArgumentExpression EOF ;
    public final EObject entryRuleArgumentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentExpression = null;


        try {
            // InternalContract.g:1217:59: (iv_ruleArgumentExpression= ruleArgumentExpression EOF )
            // InternalContract.g:1218:2: iv_ruleArgumentExpression= ruleArgumentExpression EOF
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
    // InternalContract.g:1224:1: ruleArgumentExpression returns [EObject current=null] : (this_ArgumentOr_0= ruleArgumentOr | this_ArgumentAnd_1= ruleArgumentAnd | this_ArgumentNot_2= ruleArgumentNot ) ;
    public final EObject ruleArgumentExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ArgumentOr_0 = null;

        EObject this_ArgumentAnd_1 = null;

        EObject this_ArgumentNot_2 = null;



        	enterRule();

        try {
            // InternalContract.g:1230:2: ( (this_ArgumentOr_0= ruleArgumentOr | this_ArgumentAnd_1= ruleArgumentAnd | this_ArgumentNot_2= ruleArgumentNot ) )
            // InternalContract.g:1231:2: (this_ArgumentOr_0= ruleArgumentOr | this_ArgumentAnd_1= ruleArgumentAnd | this_ArgumentNot_2= ruleArgumentNot )
            {
            // InternalContract.g:1231:2: (this_ArgumentOr_0= ruleArgumentOr | this_ArgumentAnd_1= ruleArgumentAnd | this_ArgumentNot_2= ruleArgumentNot )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt30=1;
                }
                break;
            case 31:
                {
                alt30=2;
                }
                break;
            case 36:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalContract.g:1232:3: this_ArgumentOr_0= ruleArgumentOr
                    {

                    			newCompositeNode(grammarAccess.getArgumentExpressionAccess().getArgumentOrParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArgumentOr_0=ruleArgumentOr();

                    state._fsp--;


                    			current = this_ArgumentOr_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalContract.g:1241:3: this_ArgumentAnd_1= ruleArgumentAnd
                    {

                    			newCompositeNode(grammarAccess.getArgumentExpressionAccess().getArgumentAndParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArgumentAnd_1=ruleArgumentAnd();

                    state._fsp--;


                    			current = this_ArgumentAnd_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalContract.g:1250:3: this_ArgumentNot_2= ruleArgumentNot
                    {

                    			newCompositeNode(grammarAccess.getArgumentExpressionAccess().getArgumentNotParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArgumentNot_2=ruleArgumentNot();

                    state._fsp--;


                    			current = this_ArgumentNot_2;
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
    // $ANTLR end "ruleArgumentExpression"


    // $ANTLR start "entryRuleArgumentAnd"
    // InternalContract.g:1262:1: entryRuleArgumentAnd returns [EObject current=null] : iv_ruleArgumentAnd= ruleArgumentAnd EOF ;
    public final EObject entryRuleArgumentAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentAnd = null;


        try {
            // InternalContract.g:1262:52: (iv_ruleArgumentAnd= ruleArgumentAnd EOF )
            // InternalContract.g:1263:2: iv_ruleArgumentAnd= ruleArgumentAnd EOF
            {
             newCompositeNode(grammarAccess.getArgumentAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArgumentAnd=ruleArgumentAnd();

            state._fsp--;

             current =iv_ruleArgumentAnd; 
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
    // $ANTLR end "entryRuleArgumentAnd"


    // $ANTLR start "ruleArgumentAnd"
    // InternalContract.g:1269:1: ruleArgumentAnd returns [EObject current=null] : ( () otherlv_1= 'and' otherlv_2= '(' this_ArgumentTerm_3= ruleArgumentTerm[$current] ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )* otherlv_6= ')' ) ;
    public final EObject ruleArgumentAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_ArgumentTerm_3 = null;

        EObject this_ArgumentTerm_5 = null;



        	enterRule();

        try {
            // InternalContract.g:1275:2: ( ( () otherlv_1= 'and' otherlv_2= '(' this_ArgumentTerm_3= ruleArgumentTerm[$current] ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )* otherlv_6= ')' ) )
            // InternalContract.g:1276:2: ( () otherlv_1= 'and' otherlv_2= '(' this_ArgumentTerm_3= ruleArgumentTerm[$current] ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )* otherlv_6= ')' )
            {
            // InternalContract.g:1276:2: ( () otherlv_1= 'and' otherlv_2= '(' this_ArgumentTerm_3= ruleArgumentTerm[$current] ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )* otherlv_6= ')' )
            // InternalContract.g:1277:3: () otherlv_1= 'and' otherlv_2= '(' this_ArgumentTerm_3= ruleArgumentTerm[$current] ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )* otherlv_6= ')'
            {
            // InternalContract.g:1277:3: ()
            // InternalContract.g:1278:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArgumentAndAccess().getArgumentAndAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,31,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getArgumentAndAccess().getAndKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getArgumentAndAccess().getLeftParenthesisKeyword_2());
            		

            			if (current==null) {
            				current = createModelElement(grammarAccess.getArgumentAndRule());
            			}
            			newCompositeNode(grammarAccess.getArgumentAndAccess().getArgumentTermParserRuleCall_3());
            		
            pushFollow(FOLLOW_37);
            this_ArgumentTerm_3=ruleArgumentTerm(current);

            state._fsp--;


            			current = this_ArgumentTerm_3;
            			afterParserOrEnumRuleCall();
            		
            // InternalContract.g:1303:3: ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==15||LA32_0==27||LA32_0==31||LA32_0==33||(LA32_0>=35 && LA32_0<=36)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalContract.g:1304:4: (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current]
            	    {
            	    // InternalContract.g:1304:4: (otherlv_4= ',' )?
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==33) ) {
            	        alt31=1;
            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // InternalContract.g:1305:5: otherlv_4= ','
            	            {
            	            otherlv_4=(Token)match(input,33,FOLLOW_36); 

            	            					newLeafNode(otherlv_4, grammarAccess.getArgumentAndAccess().getCommaKeyword_4_0());
            	            				

            	            }
            	            break;

            	    }


            	    				if (current==null) {
            	    					current = createModelElement(grammarAccess.getArgumentAndRule());
            	    				}
            	    				newCompositeNode(grammarAccess.getArgumentAndAccess().getArgumentTermParserRuleCall_4_1());
            	    			
            	    pushFollow(FOLLOW_37);
            	    this_ArgumentTerm_5=ruleArgumentTerm(current);

            	    state._fsp--;


            	    				current = this_ArgumentTerm_5;
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_6=(Token)match(input,34,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getArgumentAndAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleArgumentAnd"


    // $ANTLR start "entryRuleArgumentOr"
    // InternalContract.g:1330:1: entryRuleArgumentOr returns [EObject current=null] : iv_ruleArgumentOr= ruleArgumentOr EOF ;
    public final EObject entryRuleArgumentOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentOr = null;


        try {
            // InternalContract.g:1330:51: (iv_ruleArgumentOr= ruleArgumentOr EOF )
            // InternalContract.g:1331:2: iv_ruleArgumentOr= ruleArgumentOr EOF
            {
             newCompositeNode(grammarAccess.getArgumentOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArgumentOr=ruleArgumentOr();

            state._fsp--;

             current =iv_ruleArgumentOr; 
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
    // $ANTLR end "entryRuleArgumentOr"


    // $ANTLR start "ruleArgumentOr"
    // InternalContract.g:1337:1: ruleArgumentOr returns [EObject current=null] : ( () otherlv_1= 'or' otherlv_2= '(' this_ArgumentTerm_3= ruleArgumentTerm[$current] ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )* otherlv_6= ')' ) ;
    public final EObject ruleArgumentOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_ArgumentTerm_3 = null;

        EObject this_ArgumentTerm_5 = null;



        	enterRule();

        try {
            // InternalContract.g:1343:2: ( ( () otherlv_1= 'or' otherlv_2= '(' this_ArgumentTerm_3= ruleArgumentTerm[$current] ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )* otherlv_6= ')' ) )
            // InternalContract.g:1344:2: ( () otherlv_1= 'or' otherlv_2= '(' this_ArgumentTerm_3= ruleArgumentTerm[$current] ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )* otherlv_6= ')' )
            {
            // InternalContract.g:1344:2: ( () otherlv_1= 'or' otherlv_2= '(' this_ArgumentTerm_3= ruleArgumentTerm[$current] ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )* otherlv_6= ')' )
            // InternalContract.g:1345:3: () otherlv_1= 'or' otherlv_2= '(' this_ArgumentTerm_3= ruleArgumentTerm[$current] ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )* otherlv_6= ')'
            {
            // InternalContract.g:1345:3: ()
            // InternalContract.g:1346:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArgumentOrAccess().getArgumentOrAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getArgumentOrAccess().getOrKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getArgumentOrAccess().getLeftParenthesisKeyword_2());
            		

            			if (current==null) {
            				current = createModelElement(grammarAccess.getArgumentOrRule());
            			}
            			newCompositeNode(grammarAccess.getArgumentOrAccess().getArgumentTermParserRuleCall_3());
            		
            pushFollow(FOLLOW_37);
            this_ArgumentTerm_3=ruleArgumentTerm(current);

            state._fsp--;


            			current = this_ArgumentTerm_3;
            			afterParserOrEnumRuleCall();
            		
            // InternalContract.g:1371:3: ( (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current] )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==15||LA34_0==27||LA34_0==31||LA34_0==33||(LA34_0>=35 && LA34_0<=36)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalContract.g:1372:4: (otherlv_4= ',' )? this_ArgumentTerm_5= ruleArgumentTerm[$current]
            	    {
            	    // InternalContract.g:1372:4: (otherlv_4= ',' )?
            	    int alt33=2;
            	    int LA33_0 = input.LA(1);

            	    if ( (LA33_0==33) ) {
            	        alt33=1;
            	    }
            	    switch (alt33) {
            	        case 1 :
            	            // InternalContract.g:1373:5: otherlv_4= ','
            	            {
            	            otherlv_4=(Token)match(input,33,FOLLOW_36); 

            	            					newLeafNode(otherlv_4, grammarAccess.getArgumentOrAccess().getCommaKeyword_4_0());
            	            				

            	            }
            	            break;

            	    }


            	    				if (current==null) {
            	    					current = createModelElement(grammarAccess.getArgumentOrRule());
            	    				}
            	    				newCompositeNode(grammarAccess.getArgumentOrAccess().getArgumentTermParserRuleCall_4_1());
            	    			
            	    pushFollow(FOLLOW_37);
            	    this_ArgumentTerm_5=ruleArgumentTerm(current);

            	    state._fsp--;


            	    				current = this_ArgumentTerm_5;
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_6=(Token)match(input,34,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getArgumentOrAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleArgumentOr"


    // $ANTLR start "entryRuleArgumentNot"
    // InternalContract.g:1398:1: entryRuleArgumentNot returns [EObject current=null] : iv_ruleArgumentNot= ruleArgumentNot EOF ;
    public final EObject entryRuleArgumentNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentNot = null;


        try {
            // InternalContract.g:1398:52: (iv_ruleArgumentNot= ruleArgumentNot EOF )
            // InternalContract.g:1399:2: iv_ruleArgumentNot= ruleArgumentNot EOF
            {
             newCompositeNode(grammarAccess.getArgumentNotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArgumentNot=ruleArgumentNot();

            state._fsp--;

             current =iv_ruleArgumentNot; 
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
    // $ANTLR end "entryRuleArgumentNot"


    // $ANTLR start "ruleArgumentNot"
    // InternalContract.g:1405:1: ruleArgumentNot returns [EObject current=null] : ( () otherlv_1= 'not' (this_ArgumentTerm_2= ruleArgumentTerm[$current] | (otherlv_3= '(' this_ArgumentTerm_4= ruleArgumentTerm[$current] otherlv_5= ')' ) ) ) ;
    public final EObject ruleArgumentNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_ArgumentTerm_2 = null;

        EObject this_ArgumentTerm_4 = null;



        	enterRule();

        try {
            // InternalContract.g:1411:2: ( ( () otherlv_1= 'not' (this_ArgumentTerm_2= ruleArgumentTerm[$current] | (otherlv_3= '(' this_ArgumentTerm_4= ruleArgumentTerm[$current] otherlv_5= ')' ) ) ) )
            // InternalContract.g:1412:2: ( () otherlv_1= 'not' (this_ArgumentTerm_2= ruleArgumentTerm[$current] | (otherlv_3= '(' this_ArgumentTerm_4= ruleArgumentTerm[$current] otherlv_5= ')' ) ) )
            {
            // InternalContract.g:1412:2: ( () otherlv_1= 'not' (this_ArgumentTerm_2= ruleArgumentTerm[$current] | (otherlv_3= '(' this_ArgumentTerm_4= ruleArgumentTerm[$current] otherlv_5= ')' ) ) )
            // InternalContract.g:1413:3: () otherlv_1= 'not' (this_ArgumentTerm_2= ruleArgumentTerm[$current] | (otherlv_3= '(' this_ArgumentTerm_4= ruleArgumentTerm[$current] otherlv_5= ')' ) )
            {
            // InternalContract.g:1413:3: ()
            // InternalContract.g:1414:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArgumentNotAccess().getArgumentNotAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,36,FOLLOW_38); 

            			newLeafNode(otherlv_1, grammarAccess.getArgumentNotAccess().getNotKeyword_1());
            		
            // InternalContract.g:1424:3: (this_ArgumentTerm_2= ruleArgumentTerm[$current] | (otherlv_3= '(' this_ArgumentTerm_4= ruleArgumentTerm[$current] otherlv_5= ')' ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==15||LA35_0==27||LA35_0==31||(LA35_0>=35 && LA35_0<=36)) ) {
                alt35=1;
            }
            else if ( (LA35_0==32) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalContract.g:1425:4: this_ArgumentTerm_2= ruleArgumentTerm[$current]
                    {

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getArgumentNotRule());
                    				}
                    				newCompositeNode(grammarAccess.getArgumentNotAccess().getArgumentTermParserRuleCall_2_0());
                    			
                    pushFollow(FOLLOW_2);
                    this_ArgumentTerm_2=ruleArgumentTerm(current);

                    state._fsp--;


                    				current = this_ArgumentTerm_2;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalContract.g:1437:4: (otherlv_3= '(' this_ArgumentTerm_4= ruleArgumentTerm[$current] otherlv_5= ')' )
                    {
                    // InternalContract.g:1437:4: (otherlv_3= '(' this_ArgumentTerm_4= ruleArgumentTerm[$current] otherlv_5= ')' )
                    // InternalContract.g:1438:5: otherlv_3= '(' this_ArgumentTerm_4= ruleArgumentTerm[$current] otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_36); 

                    					newLeafNode(otherlv_3, grammarAccess.getArgumentNotAccess().getLeftParenthesisKeyword_2_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getArgumentNotRule());
                    					}
                    					newCompositeNode(grammarAccess.getArgumentNotAccess().getArgumentTermParserRuleCall_2_1_1());
                    				
                    pushFollow(FOLLOW_39);
                    this_ArgumentTerm_4=ruleArgumentTerm(current);

                    state._fsp--;


                    					current = this_ArgumentTerm_4;
                    					afterParserOrEnumRuleCall();
                    				
                    otherlv_5=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(otherlv_5, grammarAccess.getArgumentNotAccess().getRightParenthesisKeyword_2_1_2());
                    				

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
    // $ANTLR end "ruleArgumentNot"


    // $ANTLR start "ruleArgumentTerm"
    // InternalContract.g:1464:1: ruleArgumentTerm[EObject in_current] returns [EObject current=in_current] : ( (otherlv_0= 'contract' ( ( ruleQPREF ) ) ) | (otherlv_2= 'argument' ( ( ruleQPREF ) ) ) | ( (lv_nested_4_0= ruleArgumentExpression ) ) ) ;
    public final EObject ruleArgumentTerm(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_nested_4_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1470:2: ( ( (otherlv_0= 'contract' ( ( ruleQPREF ) ) ) | (otherlv_2= 'argument' ( ( ruleQPREF ) ) ) | ( (lv_nested_4_0= ruleArgumentExpression ) ) ) )
            // InternalContract.g:1471:2: ( (otherlv_0= 'contract' ( ( ruleQPREF ) ) ) | (otherlv_2= 'argument' ( ( ruleQPREF ) ) ) | ( (lv_nested_4_0= ruleArgumentExpression ) ) )
            {
            // InternalContract.g:1471:2: ( (otherlv_0= 'contract' ( ( ruleQPREF ) ) ) | (otherlv_2= 'argument' ( ( ruleQPREF ) ) ) | ( (lv_nested_4_0= ruleArgumentExpression ) ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt36=1;
                }
                break;
            case 27:
                {
                alt36=2;
                }
                break;
            case 31:
            case 35:
            case 36:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalContract.g:1472:3: (otherlv_0= 'contract' ( ( ruleQPREF ) ) )
                    {
                    // InternalContract.g:1472:3: (otherlv_0= 'contract' ( ( ruleQPREF ) ) )
                    // InternalContract.g:1473:4: otherlv_0= 'contract' ( ( ruleQPREF ) )
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getArgumentTermAccess().getContractKeyword_0_0());
                    			
                    // InternalContract.g:1477:4: ( ( ruleQPREF ) )
                    // InternalContract.g:1478:5: ( ruleQPREF )
                    {
                    // InternalContract.g:1478:5: ( ruleQPREF )
                    // InternalContract.g:1479:6: ruleQPREF
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getArgumentTermRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getArgumentTermAccess().getContractsContractElementCrossReference_0_1_0());
                    					
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
                    // InternalContract.g:1495:3: (otherlv_2= 'argument' ( ( ruleQPREF ) ) )
                    {
                    // InternalContract.g:1495:3: (otherlv_2= 'argument' ( ( ruleQPREF ) ) )
                    // InternalContract.g:1496:4: otherlv_2= 'argument' ( ( ruleQPREF ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getArgumentTermAccess().getArgumentKeyword_1_0());
                    			
                    // InternalContract.g:1500:4: ( ( ruleQPREF ) )
                    // InternalContract.g:1501:5: ( ruleQPREF )
                    {
                    // InternalContract.g:1501:5: ( ruleQPREF )
                    // InternalContract.g:1502:6: ruleQPREF
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getArgumentTermRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getArgumentTermAccess().getArgumentsContractElementCrossReference_1_1_0());
                    					
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
                    // InternalContract.g:1518:3: ( (lv_nested_4_0= ruleArgumentExpression ) )
                    {
                    // InternalContract.g:1518:3: ( (lv_nested_4_0= ruleArgumentExpression ) )
                    // InternalContract.g:1519:4: (lv_nested_4_0= ruleArgumentExpression )
                    {
                    // InternalContract.g:1519:4: (lv_nested_4_0= ruleArgumentExpression )
                    // InternalContract.g:1520:5: lv_nested_4_0= ruleArgumentExpression
                    {

                    					newCompositeNode(grammarAccess.getArgumentTermAccess().getNestedArgumentExpressionParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_nested_4_0=ruleArgumentExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getArgumentTermRule());
                    					}
                    					add(
                    						current,
                    						"nested",
                    						lv_nested_4_0,
                    						"org.osate.sysmlv2.contract.Contract.ArgumentExpression");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleArgumentTerm"


    // $ANTLR start "entryRuleVerificationPlan"
    // InternalContract.g:1541:1: entryRuleVerificationPlan returns [EObject current=null] : iv_ruleVerificationPlan= ruleVerificationPlan EOF ;
    public final EObject entryRuleVerificationPlan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationPlan = null;


        try {
            // InternalContract.g:1541:57: (iv_ruleVerificationPlan= ruleVerificationPlan EOF )
            // InternalContract.g:1542:2: iv_ruleVerificationPlan= ruleVerificationPlan EOF
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
    // InternalContract.g:1548:1: ruleVerificationPlan returns [EObject current=null] : (otherlv_0= 'verification' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'component' this_ID_5= RULE_ID otherlv_6= ':' ( ( ruleQCREF ) ) otherlv_8= ';' (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )? (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )? (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )? otherlv_16= '}' ) ;
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
            // InternalContract.g:1554:2: ( (otherlv_0= 'verification' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'component' this_ID_5= RULE_ID otherlv_6= ':' ( ( ruleQCREF ) ) otherlv_8= ';' (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )? (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )? (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )? otherlv_16= '}' ) )
            // InternalContract.g:1555:2: (otherlv_0= 'verification' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'component' this_ID_5= RULE_ID otherlv_6= ':' ( ( ruleQCREF ) ) otherlv_8= ';' (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )? (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )? (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )? otherlv_16= '}' )
            {
            // InternalContract.g:1555:2: (otherlv_0= 'verification' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'component' this_ID_5= RULE_ID otherlv_6= ':' ( ( ruleQCREF ) ) otherlv_8= ';' (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )? (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )? (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )? otherlv_16= '}' )
            // InternalContract.g:1556:3: otherlv_0= 'verification' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'component' this_ID_5= RULE_ID otherlv_6= ':' ( ( ruleQCREF ) ) otherlv_8= ';' (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )? (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )? (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_40); 

            			newLeafNode(otherlv_0, grammarAccess.getVerificationPlanAccess().getVerificationKeyword_0());
            		
            otherlv_1=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getVerificationPlanAccess().getPlanKeyword_1());
            		
            // InternalContract.g:1564:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalContract.g:1565:4: (lv_name_2_0= RULE_ID )
            {
            // InternalContract.g:1565:4: (lv_name_2_0= RULE_ID )
            // InternalContract.g:1566:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_2_0, grammarAccess.getVerificationPlanAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVerificationPlanRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.osate.sysmlv2.contract.Contract.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getVerificationPlanAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getVerificationPlanAccess().getComponentKeyword_4());
            		
            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_42); 

            			newLeafNode(this_ID_5, grammarAccess.getVerificationPlanAccess().getIDTerminalRuleCall_5());
            		
            otherlv_6=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getVerificationPlanAccess().getColonKeyword_6());
            		
            // InternalContract.g:1598:3: ( ( ruleQCREF ) )
            // InternalContract.g:1599:4: ( ruleQCREF )
            {
            // InternalContract.g:1599:4: ( ruleQCREF )
            // InternalContract.g:1600:5: ruleQCREF
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVerificationPlanRule());
            					}
            				

            					newCompositeNode(grammarAccess.getVerificationPlanAccess().getComponentImplementationOccurrenceDefinitionCrossReference_7_0());
            				
            pushFollow(FOLLOW_4);
            ruleQCREF();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,14,FOLLOW_43); 

            			newLeafNode(otherlv_8, grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_8());
            		
            // InternalContract.g:1618:3: (otherlv_9= 'domains' this_Domains_10= ruleDomains[$current] )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==17) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalContract.g:1619:4: otherlv_9= 'domains' this_Domains_10= ruleDomains[$current]
                    {
                    otherlv_9=(Token)match(input,17,FOLLOW_44); 

                    				newLeafNode(otherlv_9, grammarAccess.getVerificationPlanAccess().getDomainsKeyword_9_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getVerificationPlanRule());
                    				}
                    				newCompositeNode(grammarAccess.getVerificationPlanAccess().getDomainsParserRuleCall_9_1());
                    			
                    pushFollow(FOLLOW_45);
                    this_Domains_10=ruleDomains(current);

                    state._fsp--;


                    				current = this_Domains_10;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:1635:3: (otherlv_11= 'claims' this_Claims_12= ruleClaims[$current] )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==41) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalContract.g:1636:4: otherlv_11= 'claims' this_Claims_12= ruleClaims[$current]
                    {
                    otherlv_11=(Token)match(input,41,FOLLOW_46); 

                    				newLeafNode(otherlv_11, grammarAccess.getVerificationPlanAccess().getClaimsKeyword_10_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getVerificationPlanRule());
                    				}
                    				newCompositeNode(grammarAccess.getVerificationPlanAccess().getClaimsParserRuleCall_10_1());
                    			
                    pushFollow(FOLLOW_47);
                    this_Claims_12=ruleClaims(current);

                    state._fsp--;


                    				current = this_Claims_12;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalContract.g:1652:3: (otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==42) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalContract.g:1653:4: otherlv_13= 'contracts' ( ( ( ruleQPREF ) )? otherlv_15= ';' )*
                    {
                    otherlv_13=(Token)match(input,42,FOLLOW_48); 

                    				newLeafNode(otherlv_13, grammarAccess.getVerificationPlanAccess().getContractsKeyword_11_0());
                    			
                    // InternalContract.g:1657:4: ( ( ( ruleQPREF ) )? otherlv_15= ';' )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID||LA40_0==14) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalContract.g:1658:5: ( ( ruleQPREF ) )? otherlv_15= ';'
                    	    {
                    	    // InternalContract.g:1658:5: ( ( ruleQPREF ) )?
                    	    int alt39=2;
                    	    int LA39_0 = input.LA(1);

                    	    if ( (LA39_0==RULE_ID) ) {
                    	        alt39=1;
                    	    }
                    	    switch (alt39) {
                    	        case 1 :
                    	            // InternalContract.g:1659:6: ( ruleQPREF )
                    	            {
                    	            // InternalContract.g:1659:6: ( ruleQPREF )
                    	            // InternalContract.g:1660:7: ruleQPREF
                    	            {

                    	            							if (current==null) {
                    	            								current = createModelElement(grammarAccess.getVerificationPlanRule());
                    	            							}
                    	            						

                    	            							newCompositeNode(grammarAccess.getVerificationPlanAccess().getContractsContractCrossReference_11_1_0_0());
                    	            						
                    	            pushFollow(FOLLOW_4);
                    	            ruleQPREF();

                    	            state._fsp--;


                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }


                    	            }
                    	            break;

                    	    }

                    	    otherlv_15=(Token)match(input,14,FOLLOW_48); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_11_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_16=(Token)match(input,24,FOLLOW_2); 

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
    // InternalContract.g:1689:1: ruleClaims[EObject in_current] returns [EObject current=in_current] : ( ( (lv_claims_0_0= ruleSource ) )? otherlv_1= ';' )* ;
    public final EObject ruleClaims(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_claims_0_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1695:2: ( ( ( (lv_claims_0_0= ruleSource ) )? otherlv_1= ';' )* )
            // InternalContract.g:1696:2: ( ( (lv_claims_0_0= ruleSource ) )? otherlv_1= ';' )*
            {
            // InternalContract.g:1696:2: ( ( (lv_claims_0_0= ruleSource ) )? otherlv_1= ';' )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_SSTRING||(LA43_0>=RULE_ISTRING_TEXT && LA43_0<=RULE_ISTRING_LEFT)||LA43_0==14||(LA43_0>=56 && LA43_0<=58)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalContract.g:1697:3: ( (lv_claims_0_0= ruleSource ) )? otherlv_1= ';'
            	    {
            	    // InternalContract.g:1697:3: ( (lv_claims_0_0= ruleSource ) )?
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==RULE_SSTRING||(LA42_0>=RULE_ISTRING_TEXT && LA42_0<=RULE_ISTRING_LEFT)||(LA42_0>=56 && LA42_0<=58)) ) {
            	        alt42=1;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // InternalContract.g:1698:4: (lv_claims_0_0= ruleSource )
            	            {
            	            // InternalContract.g:1698:4: (lv_claims_0_0= ruleSource )
            	            // InternalContract.g:1699:5: lv_claims_0_0= ruleSource
            	            {

            	            					newCompositeNode(grammarAccess.getClaimsAccess().getClaimsSourceParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_4);
            	            lv_claims_0_0=ruleSource();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getClaimsRule());
            	            					}
            	            					add(
            	            						current,
            	            						"claims",
            	            						lv_claims_0_0,
            	            						"org.osate.sysmlv2.contract.Contract.Source");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_1=(Token)match(input,14,FOLLOW_24); 

            	    			newLeafNode(otherlv_1, grammarAccess.getClaimsAccess().getSemicolonKeyword_1());
            	    		

            	    }
            	    break;

            	default :
            	    break loop43;
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
    // InternalContract.g:1724:1: entryRuleQuery returns [EObject current=null] : iv_ruleQuery= ruleQuery EOF ;
    public final EObject entryRuleQuery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuery = null;


        try {
            // InternalContract.g:1724:46: (iv_ruleQuery= ruleQuery EOF )
            // InternalContract.g:1725:2: iv_ruleQuery= ruleQuery EOF
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
    // InternalContract.g:1731:1: ruleQuery returns [EObject current=null] : (this_SingleValDeclaration_0= ruleSingleValDeclaration | ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) ) ) ;
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
            // InternalContract.g:1737:2: ( (this_SingleValDeclaration_0= ruleSingleValDeclaration | ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) ) ) )
            // InternalContract.g:1738:2: (this_SingleValDeclaration_0= ruleSingleValDeclaration | ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) ) )
            {
            // InternalContract.g:1738:2: (this_SingleValDeclaration_0= ruleSingleValDeclaration | ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==43) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==RULE_ID) ) {
                    alt45=1;
                }
                else if ( (LA45_1==32) ) {
                    alt45=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalContract.g:1739:3: this_SingleValDeclaration_0= ruleSingleValDeclaration
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
                    // InternalContract.g:1748:3: ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) )
                    {
                    // InternalContract.g:1748:3: ( () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) ) )
                    // InternalContract.g:1749:4: () otherlv_2= 'val' otherlv_3= '(' ( (lv_names_4_0= ruleTupleName ) ) (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+ otherlv_7= ')' otherlv_8= '=' ( (lv_value_9_0= ruleExpression ) )
                    {
                    // InternalContract.g:1749:4: ()
                    // InternalContract.g:1750:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getQueryAccess().getTupleDeclarationAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,43,FOLLOW_35); 

                    				newLeafNode(otherlv_2, grammarAccess.getQueryAccess().getValKeyword_1_1());
                    			
                    otherlv_3=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getQueryAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalContract.g:1764:4: ( (lv_names_4_0= ruleTupleName ) )
                    // InternalContract.g:1765:5: (lv_names_4_0= ruleTupleName )
                    {
                    // InternalContract.g:1765:5: (lv_names_4_0= ruleTupleName )
                    // InternalContract.g:1766:6: lv_names_4_0= ruleTupleName
                    {

                    						newCompositeNode(grammarAccess.getQueryAccess().getNamesTupleNameParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_49);
                    lv_names_4_0=ruleTupleName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getQueryRule());
                    						}
                    						add(
                    							current,
                    							"names",
                    							lv_names_4_0,
                    							"org.osate.sysmlv2.contract.Contract.TupleName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:1783:4: (otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) ) )+
                    int cnt44=0;
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==33) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalContract.g:1784:5: otherlv_5= ',' ( (lv_names_6_0= ruleTupleName ) )
                    	    {
                    	    otherlv_5=(Token)match(input,33,FOLLOW_3); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getQueryAccess().getCommaKeyword_1_4_0());
                    	    				
                    	    // InternalContract.g:1788:5: ( (lv_names_6_0= ruleTupleName ) )
                    	    // InternalContract.g:1789:6: (lv_names_6_0= ruleTupleName )
                    	    {
                    	    // InternalContract.g:1789:6: (lv_names_6_0= ruleTupleName )
                    	    // InternalContract.g:1790:7: lv_names_6_0= ruleTupleName
                    	    {

                    	    							newCompositeNode(grammarAccess.getQueryAccess().getNamesTupleNameParserRuleCall_1_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    lv_names_6_0=ruleTupleName();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getQueryRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"names",
                    	    								lv_names_6_0,
                    	    								"org.osate.sysmlv2.contract.Contract.TupleName");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


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

                    otherlv_7=(Token)match(input,34,FOLLOW_51); 

                    				newLeafNode(otherlv_7, grammarAccess.getQueryAccess().getRightParenthesisKeyword_1_5());
                    			
                    otherlv_8=(Token)match(input,44,FOLLOW_52); 

                    				newLeafNode(otherlv_8, grammarAccess.getQueryAccess().getEqualsSignKeyword_1_6());
                    			
                    // InternalContract.g:1816:4: ( (lv_value_9_0= ruleExpression ) )
                    // InternalContract.g:1817:5: (lv_value_9_0= ruleExpression )
                    {
                    // InternalContract.g:1817:5: (lv_value_9_0= ruleExpression )
                    // InternalContract.g:1818:6: lv_value_9_0= ruleExpression
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
                    							"org.osate.sysmlv2.contract.Contract.Expression");
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
    // InternalContract.g:1840:1: entryRuleSingleValDeclaration returns [EObject current=null] : iv_ruleSingleValDeclaration= ruleSingleValDeclaration EOF ;
    public final EObject entryRuleSingleValDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValDeclaration = null;


        try {
            // InternalContract.g:1840:61: (iv_ruleSingleValDeclaration= ruleSingleValDeclaration EOF )
            // InternalContract.g:1841:2: iv_ruleSingleValDeclaration= ruleSingleValDeclaration EOF
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
    // InternalContract.g:1847:1: ruleSingleValDeclaration returns [EObject current=null] : (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleSingleValDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1853:2: ( (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalContract.g:1854:2: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalContract.g:1854:2: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleExpression ) ) )
            // InternalContract.g:1855:3: otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSingleValDeclarationAccess().getValKeyword_0());
            		
            // InternalContract.g:1859:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:1860:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:1860:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:1861:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_51); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSingleValDeclarationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingleValDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.osate.sysmlv2.contract.Contract.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,44,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getSingleValDeclarationAccess().getEqualsSignKeyword_2());
            		
            // InternalContract.g:1881:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalContract.g:1882:4: (lv_value_3_0= ruleExpression )
            {
            // InternalContract.g:1882:4: (lv_value_3_0= ruleExpression )
            // InternalContract.g:1883:5: lv_value_3_0= ruleExpression
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
            						"org.osate.sysmlv2.contract.Contract.Expression");
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
    // InternalContract.g:1904:1: entryRuleTupleName returns [EObject current=null] : iv_ruleTupleName= ruleTupleName EOF ;
    public final EObject entryRuleTupleName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleName = null;


        try {
            // InternalContract.g:1904:50: (iv_ruleTupleName= ruleTupleName EOF )
            // InternalContract.g:1905:2: iv_ruleTupleName= ruleTupleName EOF
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
    // InternalContract.g:1911:1: ruleTupleName returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleTupleName() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:1917:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalContract.g:1918:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalContract.g:1918:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalContract.g:1919:3: (lv_name_0_0= RULE_ID )
            {
            // InternalContract.g:1919:3: (lv_name_0_0= RULE_ID )
            // InternalContract.g:1920:4: lv_name_0_0= RULE_ID
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
            					"org.osate.sysmlv2.contract.Contract.ID");
            			

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
    // InternalContract.g:1939:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalContract.g:1939:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalContract.g:1940:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalContract.g:1946:1: ruleExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1952:2: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalContract.g:1953:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalContract.g:1953:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalContract.g:1954:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_53);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;


            			current = this_AndExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalContract.g:1962:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==45) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalContract.g:1963:4: () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalContract.g:1963:4: ()
            	    // InternalContract.g:1964:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getExpressionAccess().getOrExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,45,FOLLOW_52); 

            	    				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	    			
            	    // InternalContract.g:1974:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalContract.g:1975:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalContract.g:1975:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalContract.g:1976:6: lv_right_3_0= ruleAndExpression
            	    {

            	    						newCompositeNode(grammarAccess.getExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_53);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.osate.sysmlv2.contract.Contract.AndExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
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
    // InternalContract.g:1998:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalContract.g:1998:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalContract.g:1999:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalContract.g:2005:1: ruleAndExpression returns [EObject current=null] : (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_NotExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2011:2: ( (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* ) )
            // InternalContract.g:2012:2: (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* )
            {
            // InternalContract.g:2012:2: (this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )* )
            // InternalContract.g:2013:3: this_NotExpression_0= ruleNotExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndExpressionAccess().getNotExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_NotExpression_0=ruleNotExpression();

            state._fsp--;


            			current = this_NotExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalContract.g:2021:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==46) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalContract.g:2022:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleNotExpression ) )
            	    {
            	    // InternalContract.g:2022:4: ()
            	    // InternalContract.g:2023:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,46,FOLLOW_52); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	    			
            	    // InternalContract.g:2033:4: ( (lv_right_3_0= ruleNotExpression ) )
            	    // InternalContract.g:2034:5: (lv_right_3_0= ruleNotExpression )
            	    {
            	    // InternalContract.g:2034:5: (lv_right_3_0= ruleNotExpression )
            	    // InternalContract.g:2035:6: lv_right_3_0= ruleNotExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_54);
            	    lv_right_3_0=ruleNotExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.osate.sysmlv2.contract.Contract.NotExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
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
    // InternalContract.g:2057:1: entryRuleNotExpression returns [EObject current=null] : iv_ruleNotExpression= ruleNotExpression EOF ;
    public final EObject entryRuleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpression = null;


        try {
            // InternalContract.g:2057:54: (iv_ruleNotExpression= ruleNotExpression EOF )
            // InternalContract.g:2058:2: iv_ruleNotExpression= ruleNotExpression EOF
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
    // InternalContract.g:2064:1: ruleNotExpression returns [EObject current=null] : (this_CallExpression_0= ruleCallExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) ) ) ;
    public final EObject ruleNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_CallExpression_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2070:2: ( (this_CallExpression_0= ruleCallExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) ) ) )
            // InternalContract.g:2071:2: (this_CallExpression_0= ruleCallExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) ) )
            {
            // InternalContract.g:2071:2: (this_CallExpression_0= ruleCallExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID||LA48_0==RULE_STRING||LA48_0==32||(LA48_0>=53 && LA48_0<=54)) ) {
                alt48=1;
            }
            else if ( (LA48_0==47) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalContract.g:2072:3: this_CallExpression_0= ruleCallExpression
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
                    // InternalContract.g:2081:3: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) )
                    {
                    // InternalContract.g:2081:3: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) ) )
                    // InternalContract.g:2082:4: () otherlv_2= '!' ( (lv_operand_3_0= ruleCallExpression ) )
                    {
                    // InternalContract.g:2082:4: ()
                    // InternalContract.g:2083:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getNotExpressionAccess().getNotExpressionAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,47,FOLLOW_55); 

                    				newLeafNode(otherlv_2, grammarAccess.getNotExpressionAccess().getExclamationMarkKeyword_1_1());
                    			
                    // InternalContract.g:2093:4: ( (lv_operand_3_0= ruleCallExpression ) )
                    // InternalContract.g:2094:5: (lv_operand_3_0= ruleCallExpression )
                    {
                    // InternalContract.g:2094:5: (lv_operand_3_0= ruleCallExpression )
                    // InternalContract.g:2095:6: lv_operand_3_0= ruleCallExpression
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
                    							"org.osate.sysmlv2.contract.Contract.CallExpression");
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
    // InternalContract.g:2117:1: entryRuleCallExpression returns [EObject current=null] : iv_ruleCallExpression= ruleCallExpression EOF ;
    public final EObject entryRuleCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExpression = null;


        try {
            // InternalContract.g:2117:55: (iv_ruleCallExpression= ruleCallExpression EOF )
            // InternalContract.g:2118:2: iv_ruleCallExpression= ruleCallExpression EOF
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
    // InternalContract.g:2124:1: ruleCallExpression returns [EObject current=null] : (this_TerminalExpression_0= ruleTerminalExpression ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>' )? (otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')' )? ( (lv_lambda_10_0= ruleLambda ) )? ) | ( () otherlv_12= '#' ( ( ruleQPREF ) ) ) )* ) ;
    public final EObject ruleCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_right_3_0=null;
        Token otherlv_4=null;
        Token lv_typeArgument_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        EObject this_TerminalExpression_0 = null;

        EObject lv_argument_8_0 = null;

        EObject lv_lambda_10_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2130:2: ( (this_TerminalExpression_0= ruleTerminalExpression ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>' )? (otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')' )? ( (lv_lambda_10_0= ruleLambda ) )? ) | ( () otherlv_12= '#' ( ( ruleQPREF ) ) ) )* ) )
            // InternalContract.g:2131:2: (this_TerminalExpression_0= ruleTerminalExpression ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>' )? (otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')' )? ( (lv_lambda_10_0= ruleLambda ) )? ) | ( () otherlv_12= '#' ( ( ruleQPREF ) ) ) )* )
            {
            // InternalContract.g:2131:2: (this_TerminalExpression_0= ruleTerminalExpression ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>' )? (otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')' )? ( (lv_lambda_10_0= ruleLambda ) )? ) | ( () otherlv_12= '#' ( ( ruleQPREF ) ) ) )* )
            // InternalContract.g:2132:3: this_TerminalExpression_0= ruleTerminalExpression ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>' )? (otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')' )? ( (lv_lambda_10_0= ruleLambda ) )? ) | ( () otherlv_12= '#' ( ( ruleQPREF ) ) ) )*
            {

            			newCompositeNode(grammarAccess.getCallExpressionAccess().getTerminalExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_56);
            this_TerminalExpression_0=ruleTerminalExpression();

            state._fsp--;


            			current = this_TerminalExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalContract.g:2140:3: ( ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>' )? (otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')' )? ( (lv_lambda_10_0= ruleLambda ) )? ) | ( () otherlv_12= '#' ( ( ruleQPREF ) ) ) )*
            loop52:
            do {
                int alt52=3;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==48) ) {
                    alt52=1;
                }
                else if ( (LA52_0==51) ) {
                    alt52=2;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalContract.g:2141:4: ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>' )? (otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')' )? ( (lv_lambda_10_0= ruleLambda ) )? )
            	    {
            	    // InternalContract.g:2141:4: ( () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>' )? (otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')' )? ( (lv_lambda_10_0= ruleLambda ) )? )
            	    // InternalContract.g:2142:5: () otherlv_2= '.' ( (lv_right_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>' )? (otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')' )? ( (lv_lambda_10_0= ruleLambda ) )?
            	    {
            	    // InternalContract.g:2142:5: ()
            	    // InternalContract.g:2143:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getCallExpressionAccess().getMemberCallLeftAction_1_0_0(),
            	    							current);
            	    					

            	    }

            	    otherlv_2=(Token)match(input,48,FOLLOW_3); 

            	    					newLeafNode(otherlv_2, grammarAccess.getCallExpressionAccess().getFullStopKeyword_1_0_1());
            	    				
            	    // InternalContract.g:2153:5: ( (lv_right_3_0= RULE_ID ) )
            	    // InternalContract.g:2154:6: (lv_right_3_0= RULE_ID )
            	    {
            	    // InternalContract.g:2154:6: (lv_right_3_0= RULE_ID )
            	    // InternalContract.g:2155:7: lv_right_3_0= RULE_ID
            	    {
            	    lv_right_3_0=(Token)match(input,RULE_ID,FOLLOW_57); 

            	    							newLeafNode(lv_right_3_0, grammarAccess.getCallExpressionAccess().getRightIDTerminalRuleCall_1_0_2_0());
            	    						

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getCallExpressionRule());
            	    							}
            	    							setWithLastConsumed(
            	    								current,
            	    								"right",
            	    								lv_right_3_0,
            	    								"org.osate.sysmlv2.contract.Contract.ID");
            	    						

            	    }


            	    }

            	    // InternalContract.g:2171:5: (otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>' )?
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==49) ) {
            	        alt49=1;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // InternalContract.g:2172:6: otherlv_4= '<' ( (lv_typeArgument_5_0= RULE_ID ) ) otherlv_6= '>'
            	            {
            	            otherlv_4=(Token)match(input,49,FOLLOW_3); 

            	            						newLeafNode(otherlv_4, grammarAccess.getCallExpressionAccess().getLessThanSignKeyword_1_0_3_0());
            	            					
            	            // InternalContract.g:2176:6: ( (lv_typeArgument_5_0= RULE_ID ) )
            	            // InternalContract.g:2177:7: (lv_typeArgument_5_0= RULE_ID )
            	            {
            	            // InternalContract.g:2177:7: (lv_typeArgument_5_0= RULE_ID )
            	            // InternalContract.g:2178:8: lv_typeArgument_5_0= RULE_ID
            	            {
            	            lv_typeArgument_5_0=(Token)match(input,RULE_ID,FOLLOW_58); 

            	            								newLeafNode(lv_typeArgument_5_0, grammarAccess.getCallExpressionAccess().getTypeArgumentIDTerminalRuleCall_1_0_3_1_0());
            	            							

            	            								if (current==null) {
            	            									current = createModelElement(grammarAccess.getCallExpressionRule());
            	            								}
            	            								setWithLastConsumed(
            	            									current,
            	            									"typeArgument",
            	            									lv_typeArgument_5_0,
            	            									"org.osate.sysmlv2.contract.Contract.ID");
            	            							

            	            }


            	            }

            	            otherlv_6=(Token)match(input,50,FOLLOW_59); 

            	            						newLeafNode(otherlv_6, grammarAccess.getCallExpressionAccess().getGreaterThanSignKeyword_1_0_3_2());
            	            					

            	            }
            	            break;

            	    }

            	    // InternalContract.g:2199:5: (otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')' )?
            	    int alt50=2;
            	    int LA50_0 = input.LA(1);

            	    if ( (LA50_0==32) ) {
            	        alt50=1;
            	    }
            	    switch (alt50) {
            	        case 1 :
            	            // InternalContract.g:2200:6: otherlv_7= '(' ( (lv_argument_8_0= ruleExpression ) ) otherlv_9= ')'
            	            {
            	            otherlv_7=(Token)match(input,32,FOLLOW_52); 

            	            						newLeafNode(otherlv_7, grammarAccess.getCallExpressionAccess().getLeftParenthesisKeyword_1_0_4_0());
            	            					
            	            // InternalContract.g:2204:6: ( (lv_argument_8_0= ruleExpression ) )
            	            // InternalContract.g:2205:7: (lv_argument_8_0= ruleExpression )
            	            {
            	            // InternalContract.g:2205:7: (lv_argument_8_0= ruleExpression )
            	            // InternalContract.g:2206:8: lv_argument_8_0= ruleExpression
            	            {

            	            								newCompositeNode(grammarAccess.getCallExpressionAccess().getArgumentExpressionParserRuleCall_1_0_4_1_0());
            	            							
            	            pushFollow(FOLLOW_39);
            	            lv_argument_8_0=ruleExpression();

            	            state._fsp--;


            	            								if (current==null) {
            	            									current = createModelElementForParent(grammarAccess.getCallExpressionRule());
            	            								}
            	            								set(
            	            									current,
            	            									"argument",
            	            									lv_argument_8_0,
            	            									"org.osate.sysmlv2.contract.Contract.Expression");
            	            								afterParserOrEnumRuleCall();
            	            							

            	            }


            	            }

            	            otherlv_9=(Token)match(input,34,FOLLOW_60); 

            	            						newLeafNode(otherlv_9, grammarAccess.getCallExpressionAccess().getRightParenthesisKeyword_1_0_4_2());
            	            					

            	            }
            	            break;

            	    }

            	    // InternalContract.g:2228:5: ( (lv_lambda_10_0= ruleLambda ) )?
            	    int alt51=2;
            	    int LA51_0 = input.LA(1);

            	    if ( (LA51_0==16) ) {
            	        alt51=1;
            	    }
            	    switch (alt51) {
            	        case 1 :
            	            // InternalContract.g:2229:6: (lv_lambda_10_0= ruleLambda )
            	            {
            	            // InternalContract.g:2229:6: (lv_lambda_10_0= ruleLambda )
            	            // InternalContract.g:2230:7: lv_lambda_10_0= ruleLambda
            	            {

            	            							newCompositeNode(grammarAccess.getCallExpressionAccess().getLambdaLambdaParserRuleCall_1_0_5_0());
            	            						
            	            pushFollow(FOLLOW_56);
            	            lv_lambda_10_0=ruleLambda();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getCallExpressionRule());
            	            							}
            	            							set(
            	            								current,
            	            								"lambda",
            	            								lv_lambda_10_0,
            	            								"org.osate.sysmlv2.contract.Contract.Lambda");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalContract.g:2249:4: ( () otherlv_12= '#' ( ( ruleQPREF ) ) )
            	    {
            	    // InternalContract.g:2249:4: ( () otherlv_12= '#' ( ( ruleQPREF ) ) )
            	    // InternalContract.g:2250:5: () otherlv_12= '#' ( ( ruleQPREF ) )
            	    {
            	    // InternalContract.g:2250:5: ()
            	    // InternalContract.g:2251:6: 
            	    {

            	    						current = forceCreateModelElementAndSet(
            	    							grammarAccess.getCallExpressionAccess().getPropertyLookupLeftAction_1_1_0(),
            	    							current);
            	    					

            	    }

            	    otherlv_12=(Token)match(input,51,FOLLOW_3); 

            	    					newLeafNode(otherlv_12, grammarAccess.getCallExpressionAccess().getNumberSignKeyword_1_1_1());
            	    				
            	    // InternalContract.g:2261:5: ( ( ruleQPREF ) )
            	    // InternalContract.g:2262:6: ( ruleQPREF )
            	    {
            	    // InternalContract.g:2262:6: ( ruleQPREF )
            	    // InternalContract.g:2263:7: ruleQPREF
            	    {

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getCallExpressionRule());
            	    							}
            	    						

            	    							newCompositeNode(grammarAccess.getCallExpressionAccess().getRightAttributeDefinitionCrossReference_1_1_2_0());
            	    						
            	    pushFollow(FOLLOW_56);
            	    ruleQPREF();

            	    state._fsp--;


            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


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
    // $ANTLR end "ruleCallExpression"


    // $ANTLR start "entryRuleLambda"
    // InternalContract.g:2283:1: entryRuleLambda returns [EObject current=null] : iv_ruleLambda= ruleLambda EOF ;
    public final EObject entryRuleLambda() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambda = null;


        try {
            // InternalContract.g:2283:47: (iv_ruleLambda= ruleLambda EOF )
            // InternalContract.g:2284:2: iv_ruleLambda= ruleLambda EOF
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
    // InternalContract.g:2290:1: ruleLambda returns [EObject current=null] : (otherlv_0= '{' ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '->' this_Queries_3= ruleQueries[$current] ( (lv_returnValue_4_0= ruleExpression ) ) otherlv_5= '}' ) ;
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
            // InternalContract.g:2296:2: ( (otherlv_0= '{' ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '->' this_Queries_3= ruleQueries[$current] ( (lv_returnValue_4_0= ruleExpression ) ) otherlv_5= '}' ) )
            // InternalContract.g:2297:2: (otherlv_0= '{' ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '->' this_Queries_3= ruleQueries[$current] ( (lv_returnValue_4_0= ruleExpression ) ) otherlv_5= '}' )
            {
            // InternalContract.g:2297:2: (otherlv_0= '{' ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '->' this_Queries_3= ruleQueries[$current] ( (lv_returnValue_4_0= ruleExpression ) ) otherlv_5= '}' )
            // InternalContract.g:2298:3: otherlv_0= '{' ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '->' this_Queries_3= ruleQueries[$current] ( (lv_returnValue_4_0= ruleExpression ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_61); 

            			newLeafNode(otherlv_0, grammarAccess.getLambdaAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalContract.g:2302:3: ( (lv_parameter_1_0= ruleParameter ) )
            // InternalContract.g:2303:4: (lv_parameter_1_0= ruleParameter )
            {
            // InternalContract.g:2303:4: (lv_parameter_1_0= ruleParameter )
            // InternalContract.g:2304:5: lv_parameter_1_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getLambdaAccess().getParameterParameterParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_62);
            lv_parameter_1_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLambdaRule());
            					}
            					set(
            						current,
            						"parameter",
            						lv_parameter_1_0,
            						"org.osate.sysmlv2.contract.Contract.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,52,FOLLOW_63); 

            			newLeafNode(otherlv_2, grammarAccess.getLambdaAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		

            			if (current==null) {
            				current = createModelElement(grammarAccess.getLambdaRule());
            			}
            			newCompositeNode(grammarAccess.getLambdaAccess().getQueriesParserRuleCall_3());
            		
            pushFollow(FOLLOW_52);
            this_Queries_3=ruleQueries(current);

            state._fsp--;


            			current = this_Queries_3;
            			afterParserOrEnumRuleCall();
            		
            // InternalContract.g:2336:3: ( (lv_returnValue_4_0= ruleExpression ) )
            // InternalContract.g:2337:4: (lv_returnValue_4_0= ruleExpression )
            {
            // InternalContract.g:2337:4: (lv_returnValue_4_0= ruleExpression )
            // InternalContract.g:2338:5: lv_returnValue_4_0= ruleExpression
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
            						"org.osate.sysmlv2.contract.Contract.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,24,FOLLOW_2); 

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
    // InternalContract.g:2363:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalContract.g:2363:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalContract.g:2364:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalContract.g:2370:1: ruleParameter returns [EObject current=null] : (this_SingleParameter_0= ruleSingleParameter | ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' ) ) ;
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
            // InternalContract.g:2376:2: ( (this_SingleParameter_0= ruleSingleParameter | ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' ) ) )
            // InternalContract.g:2377:2: (this_SingleParameter_0= ruleSingleParameter | ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' ) )
            {
            // InternalContract.g:2377:2: (this_SingleParameter_0= ruleSingleParameter | ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            else if ( (LA54_0==32) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalContract.g:2378:3: this_SingleParameter_0= ruleSingleParameter
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
                    // InternalContract.g:2387:3: ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' )
                    {
                    // InternalContract.g:2387:3: ( () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')' )
                    // InternalContract.g:2388:4: () otherlv_2= '(' ( (lv_names_3_0= ruleTupleName ) ) (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+ otherlv_6= ')'
                    {
                    // InternalContract.g:2388:4: ()
                    // InternalContract.g:2389:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getParameterAccess().getTupleParameterAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalContract.g:2399:4: ( (lv_names_3_0= ruleTupleName ) )
                    // InternalContract.g:2400:5: (lv_names_3_0= ruleTupleName )
                    {
                    // InternalContract.g:2400:5: (lv_names_3_0= ruleTupleName )
                    // InternalContract.g:2401:6: lv_names_3_0= ruleTupleName
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getNamesTupleNameParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_49);
                    lv_names_3_0=ruleTupleName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						add(
                    							current,
                    							"names",
                    							lv_names_3_0,
                    							"org.osate.sysmlv2.contract.Contract.TupleName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:2418:4: (otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) ) )+
                    int cnt53=0;
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==33) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalContract.g:2419:5: otherlv_4= ',' ( (lv_names_5_0= ruleTupleName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getCommaKeyword_1_3_0());
                    	    				
                    	    // InternalContract.g:2423:5: ( (lv_names_5_0= ruleTupleName ) )
                    	    // InternalContract.g:2424:6: (lv_names_5_0= ruleTupleName )
                    	    {
                    	    // InternalContract.g:2424:6: (lv_names_5_0= ruleTupleName )
                    	    // InternalContract.g:2425:7: lv_names_5_0= ruleTupleName
                    	    {

                    	    							newCompositeNode(grammarAccess.getParameterAccess().getNamesTupleNameParserRuleCall_1_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
                    	    lv_names_5_0=ruleTupleName();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getParameterRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"names",
                    	    								lv_names_5_0,
                    	    								"org.osate.sysmlv2.contract.Contract.TupleName");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt53 >= 1 ) break loop53;
                                EarlyExitException eee =
                                    new EarlyExitException(53, input);
                                throw eee;
                        }
                        cnt53++;
                    } while (true);

                    otherlv_6=(Token)match(input,34,FOLLOW_2); 

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
    // InternalContract.g:2452:1: entryRuleSingleParameter returns [EObject current=null] : iv_ruleSingleParameter= ruleSingleParameter EOF ;
    public final EObject entryRuleSingleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleParameter = null;


        try {
            // InternalContract.g:2452:56: (iv_ruleSingleParameter= ruleSingleParameter EOF )
            // InternalContract.g:2453:2: iv_ruleSingleParameter= ruleSingleParameter EOF
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
    // InternalContract.g:2459:1: ruleSingleParameter returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleSingleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:2465:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalContract.g:2466:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalContract.g:2466:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalContract.g:2467:3: (lv_name_0_0= RULE_ID )
            {
            // InternalContract.g:2467:3: (lv_name_0_0= RULE_ID )
            // InternalContract.g:2468:4: lv_name_0_0= RULE_ID
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
            					"org.osate.sysmlv2.contract.Contract.ID");
            			

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
    // InternalContract.g:2487:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // InternalContract.g:2487:59: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // InternalContract.g:2488:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
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
    // InternalContract.g:2494:1: ruleTerminalExpression returns [EObject current=null] : ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'root' ) | ( () ( (lv_value_5_0= RULE_STRING ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression ( () (otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) ) )+ )? otherlv_13= ')' ) ) ;
    public final EObject ruleTerminalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_value_5_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject this_Expression_9 = null;

        EObject lv_elements_12_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2500:2: ( ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'root' ) | ( () ( (lv_value_5_0= RULE_STRING ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression ( () (otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) ) )+ )? otherlv_13= ')' ) ) )
            // InternalContract.g:2501:2: ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'root' ) | ( () ( (lv_value_5_0= RULE_STRING ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression ( () (otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) ) )+ )? otherlv_13= ')' ) )
            {
            // InternalContract.g:2501:2: ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'root' ) | ( () ( (lv_value_5_0= RULE_STRING ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= '(' this_Expression_9= ruleExpression ( () (otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) ) )+ )? otherlv_13= ')' ) )
            int alt57=5;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt57=1;
                }
                break;
            case 54:
                {
                alt57=2;
                }
                break;
            case RULE_STRING:
                {
                alt57=3;
                }
                break;
            case RULE_ID:
                {
                alt57=4;
                }
                break;
            case 32:
                {
                alt57=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalContract.g:2502:3: ( () otherlv_1= 'self' )
                    {
                    // InternalContract.g:2502:3: ( () otherlv_1= 'self' )
                    // InternalContract.g:2503:4: () otherlv_1= 'self'
                    {
                    // InternalContract.g:2503:4: ()
                    // InternalContract.g:2504:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getSelfExpressionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,53,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getTerminalExpressionAccess().getSelfKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:2516:3: ( () otherlv_3= 'root' )
                    {
                    // InternalContract.g:2516:3: ( () otherlv_3= 'root' )
                    // InternalContract.g:2517:4: () otherlv_3= 'root'
                    {
                    // InternalContract.g:2517:4: ()
                    // InternalContract.g:2518:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getRootExpressionAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,54,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getTerminalExpressionAccess().getRootKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalContract.g:2530:3: ( () ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // InternalContract.g:2530:3: ( () ( (lv_value_5_0= RULE_STRING ) ) )
                    // InternalContract.g:2531:4: () ( (lv_value_5_0= RULE_STRING ) )
                    {
                    // InternalContract.g:2531:4: ()
                    // InternalContract.g:2532:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getStringLiteralAction_2_0(),
                    						current);
                    				

                    }

                    // InternalContract.g:2538:4: ( (lv_value_5_0= RULE_STRING ) )
                    // InternalContract.g:2539:5: (lv_value_5_0= RULE_STRING )
                    {
                    // InternalContract.g:2539:5: (lv_value_5_0= RULE_STRING )
                    // InternalContract.g:2540:6: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_5_0, grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTerminalExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"org.osate.sysmlv2.contract.Contract.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalContract.g:2558:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalContract.g:2558:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    // InternalContract.g:2559:4: () ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalContract.g:2559:4: ()
                    // InternalContract.g:2560:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getNameReferenceAction_3_0(),
                    						current);
                    				

                    }

                    // InternalContract.g:2566:4: ( (otherlv_7= RULE_ID ) )
                    // InternalContract.g:2567:5: (otherlv_7= RULE_ID )
                    {
                    // InternalContract.g:2567:5: (otherlv_7= RULE_ID )
                    // InternalContract.g:2568:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTerminalExpressionRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_7, grammarAccess.getTerminalExpressionAccess().getReferenceElementCrossReference_3_1_0());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalContract.g:2581:3: (otherlv_8= '(' this_Expression_9= ruleExpression ( () (otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) ) )+ )? otherlv_13= ')' )
                    {
                    // InternalContract.g:2581:3: (otherlv_8= '(' this_Expression_9= ruleExpression ( () (otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) ) )+ )? otherlv_13= ')' )
                    // InternalContract.g:2582:4: otherlv_8= '(' this_Expression_9= ruleExpression ( () (otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) ) )+ )? otherlv_13= ')'
                    {
                    otherlv_8=(Token)match(input,32,FOLLOW_52); 

                    				newLeafNode(otherlv_8, grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_4_0());
                    			

                    				newCompositeNode(grammarAccess.getTerminalExpressionAccess().getExpressionParserRuleCall_4_1());
                    			
                    pushFollow(FOLLOW_50);
                    this_Expression_9=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_9;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalContract.g:2594:4: ( () (otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) ) )+ )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==33) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // InternalContract.g:2595:5: () (otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) ) )+
                            {
                            // InternalContract.g:2595:5: ()
                            // InternalContract.g:2596:6: 
                            {

                            						current = forceCreateModelElementAndAdd(
                            							grammarAccess.getTerminalExpressionAccess().getTupleExpressionElementsAction_4_2_0(),
                            							current);
                            					

                            }

                            // InternalContract.g:2602:5: (otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) ) )+
                            int cnt55=0;
                            loop55:
                            do {
                                int alt55=2;
                                int LA55_0 = input.LA(1);

                                if ( (LA55_0==33) ) {
                                    alt55=1;
                                }


                                switch (alt55) {
                            	case 1 :
                            	    // InternalContract.g:2603:6: otherlv_11= ',' ( (lv_elements_12_0= ruleExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,33,FOLLOW_52); 

                            	    						newLeafNode(otherlv_11, grammarAccess.getTerminalExpressionAccess().getCommaKeyword_4_2_1_0());
                            	    					
                            	    // InternalContract.g:2607:6: ( (lv_elements_12_0= ruleExpression ) )
                            	    // InternalContract.g:2608:7: (lv_elements_12_0= ruleExpression )
                            	    {
                            	    // InternalContract.g:2608:7: (lv_elements_12_0= ruleExpression )
                            	    // InternalContract.g:2609:8: lv_elements_12_0= ruleExpression
                            	    {

                            	    								newCompositeNode(grammarAccess.getTerminalExpressionAccess().getElementsExpressionParserRuleCall_4_2_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_50);
                            	    lv_elements_12_0=ruleExpression();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getTerminalExpressionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"elements",
                            	    									lv_elements_12_0,
                            	    									"org.osate.sysmlv2.contract.Contract.Expression");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt55 >= 1 ) break loop55;
                                        EarlyExitException eee =
                                            new EarlyExitException(55, input);
                                        throw eee;
                                }
                                cnt55++;
                            } while (true);


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,34,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getTerminalExpressionAccess().getRightParenthesisKeyword_4_3());
                    			

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


    // $ANTLR start "entryRuleIString"
    // InternalContract.g:2637:1: entryRuleIString returns [EObject current=null] : iv_ruleIString= ruleIString EOF ;
    public final EObject entryRuleIString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIString = null;


        try {
            // InternalContract.g:2637:48: (iv_ruleIString= ruleIString EOF )
            // InternalContract.g:2638:2: iv_ruleIString= ruleIString EOF
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
    // InternalContract.g:2644:1: ruleIString returns [EObject current=null] : ( ( (lv_parts_0_0= ruleIStringLiteral ) ) | ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) ) ) ;
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
            // InternalContract.g:2650:2: ( ( ( (lv_parts_0_0= ruleIStringLiteral ) ) | ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) ) ) )
            // InternalContract.g:2651:2: ( ( (lv_parts_0_0= ruleIStringLiteral ) ) | ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) ) )
            {
            // InternalContract.g:2651:2: ( ( (lv_parts_0_0= ruleIStringLiteral ) ) | ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_ISTRING_TEXT) ) {
                alt61=1;
            }
            else if ( (LA61_0==RULE_ISTRING_LEFT) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalContract.g:2652:3: ( (lv_parts_0_0= ruleIStringLiteral ) )
                    {
                    // InternalContract.g:2652:3: ( (lv_parts_0_0= ruleIStringLiteral ) )
                    // InternalContract.g:2653:4: (lv_parts_0_0= ruleIStringLiteral )
                    {
                    // InternalContract.g:2653:4: (lv_parts_0_0= ruleIStringLiteral )
                    // InternalContract.g:2654:5: lv_parts_0_0= ruleIStringLiteral
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
                    						"org.osate.sysmlv2.contract.Contract.IStringLiteral");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:2672:3: ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) )
                    {
                    // InternalContract.g:2672:3: ( ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) ) )
                    // InternalContract.g:2673:4: ( (lv_parts_1_0= ruleIStringLeftLiteral ) ) ( (lv_parts_2_0= ruleIStringInter ) )? ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )* ( (lv_parts_5_0= ruleIStringRightLiteral ) )
                    {
                    // InternalContract.g:2673:4: ( (lv_parts_1_0= ruleIStringLeftLiteral ) )
                    // InternalContract.g:2674:5: (lv_parts_1_0= ruleIStringLeftLiteral )
                    {
                    // InternalContract.g:2674:5: (lv_parts_1_0= ruleIStringLeftLiteral )
                    // InternalContract.g:2675:6: lv_parts_1_0= ruleIStringLeftLiteral
                    {

                    						newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringLeftLiteralParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_64);
                    lv_parts_1_0=ruleIStringLeftLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIStringRule());
                    						}
                    						add(
                    							current,
                    							"parts",
                    							lv_parts_1_0,
                    							"org.osate.sysmlv2.contract.Contract.IStringLeftLiteral");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:2692:4: ( (lv_parts_2_0= ruleIStringInter ) )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==RULE_ID||LA58_0==40||(LA58_0>=59 && LA58_0<=60)) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // InternalContract.g:2693:5: (lv_parts_2_0= ruleIStringInter )
                            {
                            // InternalContract.g:2693:5: (lv_parts_2_0= ruleIStringInter )
                            // InternalContract.g:2694:6: lv_parts_2_0= ruleIStringInter
                            {

                            						newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringInterParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_64);
                            lv_parts_2_0=ruleIStringInter();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getIStringRule());
                            						}
                            						add(
                            							current,
                            							"parts",
                            							lv_parts_2_0,
                            							"org.osate.sysmlv2.contract.Contract.IStringInter");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalContract.g:2711:4: ( ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )? )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==RULE_ISTRING_MIDDLE) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalContract.g:2712:5: ( (lv_parts_3_0= ruleIStringMiddleLiteral ) ) ( (lv_parts_4_0= ruleIStringInter ) )?
                    	    {
                    	    // InternalContract.g:2712:5: ( (lv_parts_3_0= ruleIStringMiddleLiteral ) )
                    	    // InternalContract.g:2713:6: (lv_parts_3_0= ruleIStringMiddleLiteral )
                    	    {
                    	    // InternalContract.g:2713:6: (lv_parts_3_0= ruleIStringMiddleLiteral )
                    	    // InternalContract.g:2714:7: lv_parts_3_0= ruleIStringMiddleLiteral
                    	    {

                    	    							newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringMiddleLiteralParserRuleCall_1_2_0_0());
                    	    						
                    	    pushFollow(FOLLOW_64);
                    	    lv_parts_3_0=ruleIStringMiddleLiteral();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getIStringRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parts",
                    	    								lv_parts_3_0,
                    	    								"org.osate.sysmlv2.contract.Contract.IStringMiddleLiteral");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    // InternalContract.g:2731:5: ( (lv_parts_4_0= ruleIStringInter ) )?
                    	    int alt59=2;
                    	    int LA59_0 = input.LA(1);

                    	    if ( (LA59_0==RULE_ID||LA59_0==40||(LA59_0>=59 && LA59_0<=60)) ) {
                    	        alt59=1;
                    	    }
                    	    switch (alt59) {
                    	        case 1 :
                    	            // InternalContract.g:2732:6: (lv_parts_4_0= ruleIStringInter )
                    	            {
                    	            // InternalContract.g:2732:6: (lv_parts_4_0= ruleIStringInter )
                    	            // InternalContract.g:2733:7: lv_parts_4_0= ruleIStringInter
                    	            {

                    	            							newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringInterParserRuleCall_1_2_1_0());
                    	            						
                    	            pushFollow(FOLLOW_64);
                    	            lv_parts_4_0=ruleIStringInter();

                    	            state._fsp--;


                    	            							if (current==null) {
                    	            								current = createModelElementForParent(grammarAccess.getIStringRule());
                    	            							}
                    	            							add(
                    	            								current,
                    	            								"parts",
                    	            								lv_parts_4_0,
                    	            								"org.osate.sysmlv2.contract.Contract.IStringInter");
                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);

                    // InternalContract.g:2751:4: ( (lv_parts_5_0= ruleIStringRightLiteral ) )
                    // InternalContract.g:2752:5: (lv_parts_5_0= ruleIStringRightLiteral )
                    {
                    // InternalContract.g:2752:5: (lv_parts_5_0= ruleIStringRightLiteral )
                    // InternalContract.g:2753:6: lv_parts_5_0= ruleIStringRightLiteral
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
                    							"org.osate.sysmlv2.contract.Contract.IStringRightLiteral");
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
    // InternalContract.g:2775:1: entryRuleIStringLiteral returns [EObject current=null] : iv_ruleIStringLiteral= ruleIStringLiteral EOF ;
    public final EObject entryRuleIStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIStringLiteral = null;


        try {
            // InternalContract.g:2775:55: (iv_ruleIStringLiteral= ruleIStringLiteral EOF )
            // InternalContract.g:2776:2: iv_ruleIStringLiteral= ruleIStringLiteral EOF
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
    // InternalContract.g:2782:1: ruleIStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_ISTRING_TEXT ) ) ;
    public final EObject ruleIStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:2788:2: ( ( (lv_value_0_0= RULE_ISTRING_TEXT ) ) )
            // InternalContract.g:2789:2: ( (lv_value_0_0= RULE_ISTRING_TEXT ) )
            {
            // InternalContract.g:2789:2: ( (lv_value_0_0= RULE_ISTRING_TEXT ) )
            // InternalContract.g:2790:3: (lv_value_0_0= RULE_ISTRING_TEXT )
            {
            // InternalContract.g:2790:3: (lv_value_0_0= RULE_ISTRING_TEXT )
            // InternalContract.g:2791:4: lv_value_0_0= RULE_ISTRING_TEXT
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
            					"org.osate.sysmlv2.contract.Contract.ISTRING_TEXT");
            			

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
    // InternalContract.g:2810:1: entryRuleIStringLeftLiteral returns [EObject current=null] : iv_ruleIStringLeftLiteral= ruleIStringLeftLiteral EOF ;
    public final EObject entryRuleIStringLeftLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIStringLeftLiteral = null;


        try {
            // InternalContract.g:2810:59: (iv_ruleIStringLeftLiteral= ruleIStringLeftLiteral EOF )
            // InternalContract.g:2811:2: iv_ruleIStringLeftLiteral= ruleIStringLeftLiteral EOF
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
    // InternalContract.g:2817:1: ruleIStringLeftLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_ISTRING_LEFT ) ) ;
    public final EObject ruleIStringLeftLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:2823:2: ( ( (lv_value_0_0= RULE_ISTRING_LEFT ) ) )
            // InternalContract.g:2824:2: ( (lv_value_0_0= RULE_ISTRING_LEFT ) )
            {
            // InternalContract.g:2824:2: ( (lv_value_0_0= RULE_ISTRING_LEFT ) )
            // InternalContract.g:2825:3: (lv_value_0_0= RULE_ISTRING_LEFT )
            {
            // InternalContract.g:2825:3: (lv_value_0_0= RULE_ISTRING_LEFT )
            // InternalContract.g:2826:4: lv_value_0_0= RULE_ISTRING_LEFT
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
            					"org.osate.sysmlv2.contract.Contract.ISTRING_LEFT");
            			

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
    // InternalContract.g:2845:1: entryRuleIStringMiddleLiteral returns [EObject current=null] : iv_ruleIStringMiddleLiteral= ruleIStringMiddleLiteral EOF ;
    public final EObject entryRuleIStringMiddleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIStringMiddleLiteral = null;


        try {
            // InternalContract.g:2845:61: (iv_ruleIStringMiddleLiteral= ruleIStringMiddleLiteral EOF )
            // InternalContract.g:2846:2: iv_ruleIStringMiddleLiteral= ruleIStringMiddleLiteral EOF
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
    // InternalContract.g:2852:1: ruleIStringMiddleLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_ISTRING_MIDDLE ) ) ;
    public final EObject ruleIStringMiddleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:2858:2: ( ( (lv_value_0_0= RULE_ISTRING_MIDDLE ) ) )
            // InternalContract.g:2859:2: ( (lv_value_0_0= RULE_ISTRING_MIDDLE ) )
            {
            // InternalContract.g:2859:2: ( (lv_value_0_0= RULE_ISTRING_MIDDLE ) )
            // InternalContract.g:2860:3: (lv_value_0_0= RULE_ISTRING_MIDDLE )
            {
            // InternalContract.g:2860:3: (lv_value_0_0= RULE_ISTRING_MIDDLE )
            // InternalContract.g:2861:4: lv_value_0_0= RULE_ISTRING_MIDDLE
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
            					"org.osate.sysmlv2.contract.Contract.ISTRING_MIDDLE");
            			

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
    // InternalContract.g:2880:1: entryRuleIStringRightLiteral returns [EObject current=null] : iv_ruleIStringRightLiteral= ruleIStringRightLiteral EOF ;
    public final EObject entryRuleIStringRightLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIStringRightLiteral = null;


        try {
            // InternalContract.g:2880:60: (iv_ruleIStringRightLiteral= ruleIStringRightLiteral EOF )
            // InternalContract.g:2881:2: iv_ruleIStringRightLiteral= ruleIStringRightLiteral EOF
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
    // InternalContract.g:2887:1: ruleIStringRightLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_ISTRING_RIGHT ) ) ;
    public final EObject ruleIStringRightLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalContract.g:2893:2: ( ( (lv_value_0_0= RULE_ISTRING_RIGHT ) ) )
            // InternalContract.g:2894:2: ( (lv_value_0_0= RULE_ISTRING_RIGHT ) )
            {
            // InternalContract.g:2894:2: ( (lv_value_0_0= RULE_ISTRING_RIGHT ) )
            // InternalContract.g:2895:3: (lv_value_0_0= RULE_ISTRING_RIGHT )
            {
            // InternalContract.g:2895:3: (lv_value_0_0= RULE_ISTRING_RIGHT )
            // InternalContract.g:2896:4: lv_value_0_0= RULE_ISTRING_RIGHT
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
            					"org.osate.sysmlv2.contract.Contract.ISTRING_RIGHT");
            			

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
    // InternalContract.g:2915:1: entryRuleIStringInter returns [EObject current=null] : iv_ruleIStringInter= ruleIStringInter EOF ;
    public final EObject entryRuleIStringInter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIStringInter = null;


        try {
            // InternalContract.g:2915:53: (iv_ruleIStringInter= ruleIStringInter EOF )
            // InternalContract.g:2916:2: iv_ruleIStringInter= ruleIStringInter EOF
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
    // InternalContract.g:2922:1: ruleIStringInter returns [EObject current=null] : ( ( (lv_direct_0_0= ':' ) )? ( ( ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ) | ( (lv_predefined_4_0= rulePredefined ) ) ) ) ;
    public final EObject ruleIStringInter() throws RecognitionException {
        EObject current = null;

        Token lv_direct_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_predefined_4_0 = null;



        	enterRule();

        try {
            // InternalContract.g:2928:2: ( ( ( (lv_direct_0_0= ':' ) )? ( ( ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ) | ( (lv_predefined_4_0= rulePredefined ) ) ) ) )
            // InternalContract.g:2929:2: ( ( (lv_direct_0_0= ':' ) )? ( ( ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ) | ( (lv_predefined_4_0= rulePredefined ) ) ) )
            {
            // InternalContract.g:2929:2: ( ( (lv_direct_0_0= ':' ) )? ( ( ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ) | ( (lv_predefined_4_0= rulePredefined ) ) ) )
            // InternalContract.g:2930:3: ( (lv_direct_0_0= ':' ) )? ( ( ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ) | ( (lv_predefined_4_0= rulePredefined ) ) )
            {
            // InternalContract.g:2930:3: ( (lv_direct_0_0= ':' ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==40) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalContract.g:2931:4: (lv_direct_0_0= ':' )
                    {
                    // InternalContract.g:2931:4: (lv_direct_0_0= ':' )
                    // InternalContract.g:2932:5: lv_direct_0_0= ':'
                    {
                    lv_direct_0_0=(Token)match(input,40,FOLLOW_65); 

                    					newLeafNode(lv_direct_0_0, grammarAccess.getIStringInterAccess().getDirectColonKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIStringInterRule());
                    					}
                    					setWithLastConsumed(current, "direct", lv_direct_0_0 != null, ":");
                    				

                    }


                    }
                    break;

            }

            // InternalContract.g:2944:3: ( ( ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ) | ( (lv_predefined_4_0= rulePredefined ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                alt64=1;
            }
            else if ( ((LA64_0>=59 && LA64_0<=60)) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalContract.g:2945:4: ( ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalContract.g:2945:4: ( ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) )
                    // InternalContract.g:2946:5: ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalContract.g:2946:5: ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==RULE_ID) ) {
                        int LA63_1 = input.LA(2);

                        if ( (LA63_1==55) ) {
                            alt63=1;
                        }
                    }
                    switch (alt63) {
                        case 1 :
                            // InternalContract.g:2947:6: ( (otherlv_1= RULE_ID ) ) otherlv_2= '::'
                            {
                            // InternalContract.g:2947:6: ( (otherlv_1= RULE_ID ) )
                            // InternalContract.g:2948:7: (otherlv_1= RULE_ID )
                            {
                            // InternalContract.g:2948:7: (otherlv_1= RULE_ID )
                            // InternalContract.g:2949:8: otherlv_1= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getIStringInterRule());
                            								}
                            							
                            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_66); 

                            								newLeafNode(otherlv_1, grammarAccess.getIStringInterAccess().getDomainDomainCrossReference_1_0_0_0_0());
                            							

                            }


                            }

                            otherlv_2=(Token)match(input,55,FOLLOW_3); 

                            						newLeafNode(otherlv_2, grammarAccess.getIStringInterAccess().getColonColonKeyword_1_0_0_1());
                            					

                            }
                            break;

                    }

                    // InternalContract.g:2965:5: ( (otherlv_3= RULE_ID ) )
                    // InternalContract.g:2966:6: (otherlv_3= RULE_ID )
                    {
                    // InternalContract.g:2966:6: (otherlv_3= RULE_ID )
                    // InternalContract.g:2967:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getIStringInterRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    							newLeafNode(otherlv_3, grammarAccess.getIStringInterAccess().getQuerySingleValDeclarationCrossReference_1_0_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:2980:4: ( (lv_predefined_4_0= rulePredefined ) )
                    {
                    // InternalContract.g:2980:4: ( (lv_predefined_4_0= rulePredefined ) )
                    // InternalContract.g:2981:5: (lv_predefined_4_0= rulePredefined )
                    {
                    // InternalContract.g:2981:5: (lv_predefined_4_0= rulePredefined )
                    // InternalContract.g:2982:6: lv_predefined_4_0= rulePredefined
                    {

                    						newCompositeNode(grammarAccess.getIStringInterAccess().getPredefinedPredefinedEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_predefined_4_0=rulePredefined();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIStringInterRule());
                    						}
                    						set(
                    							current,
                    							"predefined",
                    							lv_predefined_4_0,
                    							"org.osate.sysmlv2.contract.Contract.Predefined");
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
    // $ANTLR end "ruleIStringInter"


    // $ANTLR start "entryRuleQPREF"
    // InternalContract.g:3004:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalContract.g:3004:45: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalContract.g:3005:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalContract.g:3011:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalContract.g:3017:2: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // InternalContract.g:3018:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // InternalContract.g:3018:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // InternalContract.g:3019:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_67); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());
            		
            // InternalContract.g:3026:3: (kw= '::' this_ID_2= RULE_ID )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==55) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalContract.g:3027:4: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,55,FOLLOW_3); 

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
    // InternalContract.g:3044:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalContract.g:3044:45: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalContract.g:3045:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalContract.g:3051:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalContract.g:3057:2: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // InternalContract.g:3058:2: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // InternalContract.g:3058:2: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // InternalContract.g:3059:3: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // InternalContract.g:3059:3: (this_ID_0= RULE_ID kw= '::' )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==RULE_ID) ) {
                    int LA66_1 = input.LA(2);

                    if ( (LA66_1==55) ) {
                        alt66=1;
                    }


                }


                switch (alt66) {
            	case 1 :
            	    // InternalContract.g:3060:4: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_66); 

            	    				current.merge(this_ID_0);
            	    			

            	    				newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0());
            	    			
            	    kw=(Token)match(input,55,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_68); 

            			current.merge(this_ID_2);
            		

            			newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());
            		
            // InternalContract.g:3080:3: (kw= '.' this_ID_4= RULE_ID )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==48) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalContract.g:3081:4: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,48,FOLLOW_3); 

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


    // $ANTLR start "ruleLanguage"
    // InternalContract.g:3098:1: ruleLanguage returns [Enumerator current=null] : ( (enumLiteral_0= 'python' ) | (enumLiteral_1= 'java' ) | (enumLiteral_2= 'smt' ) ) ;
    public final Enumerator ruleLanguage() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalContract.g:3104:2: ( ( (enumLiteral_0= 'python' ) | (enumLiteral_1= 'java' ) | (enumLiteral_2= 'smt' ) ) )
            // InternalContract.g:3105:2: ( (enumLiteral_0= 'python' ) | (enumLiteral_1= 'java' ) | (enumLiteral_2= 'smt' ) )
            {
            // InternalContract.g:3105:2: ( (enumLiteral_0= 'python' ) | (enumLiteral_1= 'java' ) | (enumLiteral_2= 'smt' ) )
            int alt68=3;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt68=1;
                }
                break;
            case 57:
                {
                alt68=2;
                }
                break;
            case 58:
                {
                alt68=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalContract.g:3106:3: (enumLiteral_0= 'python' )
                    {
                    // InternalContract.g:3106:3: (enumLiteral_0= 'python' )
                    // InternalContract.g:3107:4: enumLiteral_0= 'python'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPYTHONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getPYTHONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:3114:3: (enumLiteral_1= 'java' )
                    {
                    // InternalContract.g:3114:3: (enumLiteral_1= 'java' )
                    // InternalContract.g:3115:4: enumLiteral_1= 'java'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getJAVAEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getJAVAEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalContract.g:3122:3: (enumLiteral_2= 'smt' )
                    {
                    // InternalContract.g:3122:3: (enumLiteral_2= 'smt' )
                    // InternalContract.g:3123:4: enumLiteral_2= 'smt'
                    {
                    enumLiteral_2=(Token)match(input,58,FOLLOW_2); 

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


    // $ANTLR start "rulePredefined"
    // InternalContract.g:3133:1: rulePredefined returns [Enumerator current=null] : ( (enumLiteral_0= 'error0' ) | (enumLiteral_1= 'info0' ) ) ;
    public final Enumerator rulePredefined() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalContract.g:3139:2: ( ( (enumLiteral_0= 'error0' ) | (enumLiteral_1= 'info0' ) ) )
            // InternalContract.g:3140:2: ( (enumLiteral_0= 'error0' ) | (enumLiteral_1= 'info0' ) )
            {
            // InternalContract.g:3140:2: ( (enumLiteral_0= 'error0' ) | (enumLiteral_1= 'info0' ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==59) ) {
                alt69=1;
            }
            else if ( (LA69_0==60) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalContract.g:3141:3: (enumLiteral_0= 'error0' )
                    {
                    // InternalContract.g:3141:3: (enumLiteral_0= 'error0' )
                    // InternalContract.g:3142:4: enumLiteral_0= 'error0'
                    {
                    enumLiteral_0=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getPredefinedAccess().getERROREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPredefinedAccess().getERROREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:3149:3: (enumLiteral_1= 'info0' )
                    {
                    // InternalContract.g:3149:3: (enumLiteral_1= 'info0' )
                    // InternalContract.g:3150:4: enumLiteral_1= 'info0'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getPredefinedAccess().getINFOEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPredefinedAccess().getINFOEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "rulePredefined"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000002028008002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000001FE0000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001FC4010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001FC0000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000080001F84000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001F80000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0700000001F041A0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0700000009E0C1A0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001E00000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x07000000000001A0L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001C00000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x07000000010041A0L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000080000004002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x070000000800C1A2L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x07000000000041A2L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000041040000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000080041004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000009220000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000009204010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000009200000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000001880000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001888008000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000001E88008000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000001988008000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000060001020000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000060001004010L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000060001000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x07000400010041A0L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000040001000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000001004010L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0060800100000050L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0060000100000050L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0009000000000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x000B000100010002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0009000100010002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0009000000010002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0060880100004050L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x1800010000000610L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x1800010000000010L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0001000000000002L});

}