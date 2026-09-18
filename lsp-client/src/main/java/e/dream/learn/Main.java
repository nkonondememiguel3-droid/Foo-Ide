package e.dream.learn;

/*
 * Lsp specification link: https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#whatIsNew
 * Http header semantic link: https://datatracker.ietf.org/doc/html/rfc7230#section-3.2
 *      Each header field consists of a case-insensitive field name followed
       by a colon (":"), optional leading whitespace, the field value, and
       optional trailing whitespace.
       -> header-field   = field-name ":" OWS field-value OWS

 * JSON-RPC 2.0 specification : https://www.jsonrpc.org/specification
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("hello lsp-client");
    }
}

