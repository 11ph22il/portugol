/* Generated By:JJTree: Do not edit this line. ASTFormalParametersList.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY= */
public class ASTFormalParametersList extends SimpleNode {
  public ASTFormalParametersList(int id) {
    super(id);
  }

  public ASTFormalParametersList(PortugolParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(PortugolParserVisitor visitor, Object data) throws Exception {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=0aaaed57da168121017b9e2b5e20a67c (do not edit this line) */