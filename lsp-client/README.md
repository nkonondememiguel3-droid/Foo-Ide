# base protocol:
the base protocol consists of a header and a content part. They
are separated by '\r\n'.

## header part:
the header part consists of header fields. Each header field
consists of a case-insensitive field name followed by a colon (":"),
optional leading whitespace, the field value, and optional trailing
whitespace.
the header fields that are supported are:
- Content-Length, which is the length of the content part in bytes
  it is required.
- Content-Type, which is the mime type of the content part.
  the header part is encoded using the 'ascii' encoding including the '\r\n'
  separating the header and the source.

## the content part:
contains the actual content of the message. it uses
JSON-RPC to describe ```requests, responses and notifications```. It is encoded using
the charset provided in the header part Content-type field. It defaults to 'utf-8'
which is the only encoding supported right now.


### This is an example of a request:
` Content-Length: ...\r\n
  Content-Type: utf-8\r\n
\r\n
{
    "jsonrpc": "2.0",
    "id": 1,
    "method": "textDocument/completion",
    "params": {
        ...
    }
}`
