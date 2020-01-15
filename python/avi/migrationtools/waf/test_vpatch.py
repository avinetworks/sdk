import xmltodict
dast=__import__("avi-iwaf-vpatch")



qualysweb_testfile = """<?xml version='1.0' encoding='UTF-8'?>
<WAS_SCAN_REPORT>
    <HEADER>
        <NAME>Scan Report</NAME>
        <DESCRIPTION>test</DESCRIPTION>
        <GENERATION_DATETIME>10 Nov 2017 12:58PM GMT-0500</GENERATION_DATETIME>
    </HEADER>
    <FILTERS>
        <FILTER>
            <NAME>REMEDIATION</NAME>
            <VALUE>Include patched findings</VALUE>
        </FILTER>
        <FILTER>
            <NAME>REMEDIATION</NAME>
            <VALUE>Show ignored findings </VALUE>
        </FILTER>
    </FILTERS>
    <TARGET>
        <SCAN>Demo Vul Scan</SCAN>
    </TARGET>
    <SUMMARY>
        <GLOBAL_SUMMARY>
            <SECURITY_RISK>High</SECURITY_RISK>
            <VULNERABILITY>42</VULNERABILITY>
            <SENSITIVE_CONTENT>0</SENSITIVE_CONTENT>
            <INFORMATION_GATHERED>19</INFORMATION_GATHERED>
        </GLOBAL_SUMMARY>
        <SUMMARY_STATS>
            <SUMMARY_STAT>
                <SCAN>Demo Vul Scan</SCAN>
                <DATE>21 Sep 2017</DATE>
                <LEVEL5>9</LEVEL5>
                <LEVEL4>3</LEVEL4>
                <LEVEL3>4</LEVEL3>
                <LEVEL2>10</LEVEL2>
                <LEVEL1>16</LEVEL1>
                <SENSITIVE_CONTENT>0</SENSITIVE_CONTENT>
                <INFORMATION_GATHERED>19</INFORMATION_GATHERED>
            </SUMMARY_STAT>
        </SUMMARY_STATS>
    </SUMMARY>
    <RESULTS>
        <VULNERABILITY_LIST>
            <VULNERABILITY>
                <ID>245034757</ID>
                <DETECTION_ID>4293576</DETECTION_ID>
                <QID>150003</QID>
                <URL>http://demo.testfire.net/bank/login.aspx</URL>
                <PARAM>passw</PARAM>
                <FORM_ENTRY_POINT>http://demo.testfire.net/bank/login.aspx</FORM_ENTRY_POINT>
                <AJAX>false</AJAX>
                <AUTHENTICATION>Not Required</AUTHENTICATION>
                <FIRST_TIME_DETECTED>21 Sep 2017 04:27PM GMT-0400</FIRST_TIME_DETECTED>
                <LAST_TIME_DETECTED>21 Sep 2017 04:27PM GMT-0400</LAST_TIME_DETECTED>
                <LAST_TIME_TESTED>21 Sep 2017 04:27PM GMT-0400</LAST_TIME_TESTED>
                <TIMES_DETECTED>1</TIMES_DETECTED>
                <PAYLOADS>
                    <PAYLOAD>
                        <NUM>1</NUM>
                        <PAYLOAD><![CDATA[uid=John&passw=%2525%7B%28%23_%3D%27multipart%2fform-data%27%29.%28%23dm%3D@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS%29.%28%23_memberAccess%3F%28%23_memberAccess%3D%23dm%29%3A%28%28%23container%3D%23context%5B%27com.opensymphony.xwork2.ActionContext.container%27%5D%29.%28%23ognlUtil%3D%23container.getInstance%28@com.opensymphony.xwork2.ognl.OgnlUtil@class%29%29.%28%23ognlUtil.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ognlUtil.getExcludedClasses%28%29.clear%28%29%29.%28%23context.setMemberAccess%28%23dm%29%29%29%29.%28%23str1%3D%27A2B8C3%27%29.%28%23str2%3D%27q9d4hi5j%27%29.%28%23str3%3D%27R9D7e8%27%29.%28%23str%3D%23str2%2b%27%3AQQ%3A%27%2b%23str1%2b%27%3ATT%3A%27%2b%23str3%29.%28%23cmd%3D%27echo%20%27%2b%20%23str%29.%28%23iswin%3D%28@java.lang.System@getProperty%28%27os.name%27%29.toLowerCase%28%29.contains%28%27win%27%29%29%29.%28%23cmds%3D%28%23iswin%3F%7B%27cmd.exe%27%2C%27%2fc%27%2C%23cmd%7D%3A%7B%27%2fbin%2fbash%27%2C%27-c%27%2C%23cmd%7D%29%29.%28%23p%3Dnew%20java.lang.ProcessBuilder%28%23cmds%29%29.%28%23p.redirectErrorStream%28true%29%29.%28%23process%3D%23p.start%28%29%29.%28%23ros%3D%28@org.apache.struts2.ServletActionContext@getResponse%28%29.getOutputStream%28%29%29%29.%28@org.apache.commons.io.IOUtils@copy%28%23process.getInputStream%28%29%2C%23ros%29%29.%28%23ros.flush%28%29%29%7D&btnSubmit=Login]]></PAYLOAD>
                        <REQUEST>
                            <METHOD>POST</METHOD>
                            <URL>http://demo.testfire.net/bank/login.aspx</URL>
                            <HEADERS>
                                <HEADER>
                                    <key>Referer</key>
                                    <value><![CDATA[ http://demo.testfire.net/bank/login.aspx]]></value>
                                </HEADER>
                                <HEADER>
                                    <key>Cookie</key>
                                    <value><![CDATA[ lang=; amSessionId=132271899100; ASP.NET_SessionId=tskomp45ivi55r4530tp5g2a;]]></value>
                                </HEADER>
                            </HEADERS>
                        </REQUEST>
                        <RESPONSE>
                            <CONTENTS base64="true"><![CDATA[bWJlckFjY2Vzcz8oI19tZW1iZXJBY2Nlc3M9I2RtKTooKCNjb250YWluZXI9I2NvbnRleHRbJ2Nv
bS5vcGVuc3ltcGhvbnkueHdvcmsyLkFjdGlvbkNvbnRleHQuY29udGFpbmVyJ10pLigjb2dubFV0
aWw9I2NvbnRhaW5lci5nZXRJbnN0YW5jZScuDTwvc3Bhbj48L2I+PC9wPg0KDQo8aDI+RXJyb3Ig
TWVzc2FnZTo8L2gyPg0KDQo8cD48c3BhbiBpZD0iX2N0bDBfQ29udGVudF9sYmxEZXRhaWxzIj5T
eXN0ZW0uRGF0YS5PbGVEYi5PbGVEYkV4Y2VwdGlvbjogU3ludGF4IGVycm9yIChtaXNzaW5nIG9w
ZXJhdG9yKSBpbiBxdWVyeSBleHByZXNzaW9uICd1c2VybmFtZSA9ICdKb2huJyBBTkQgcGFzc3dv
cmQgPSAnJTI1eygjXz0nbXVsdGlwYXJ0L2Zvcm0tZGF0YScpLigjZG09QG9nbmwuT2dubENvbnRl
eHRAREVGQVVMVF9NRU1CRVJfQUNDRVNTKS4oI19tZW1iZXJBY2Nlc3M/KCNfbWVtYmVyQWNjZXNz
PSNkbSk6KCgjY29udGFpbmVyPSNjb250ZXh0Wydjb20ub3BlbnN5bXBob24=
]]></CONTENTS>
                            <EVIDENCE base64="true"><![CDATA[U3lzdGVtLkRhdGEuT2xlRGIuT2xlRGJFeGNlcHRpb246IFN5bnRheCBlcnJvcg==
]]></EVIDENCE>
                        </RESPONSE>
                    </PAYLOAD>
                </PAYLOADS>
                <IGNORED>false</IGNORED>
            </VULNERABILITY>
            <VULNERABILITY>
                <ID>245034772</ID>
                <DETECTION_ID>4293591</DETECTION_ID>
                <QID>150013</QID>
                <URL>http://demo.testfire.net/notfound.aspx?aspxerrorpath=/Privacypolicy.aspx</URL>
                <PARAM>aspxerrorpath</PARAM>
                <ACCESS_PATH>
                    <URL>http://demo.testfire.net/bank/login.aspx</URL>
                    <URL>http://demo.testfire.net/default.aspx?content=inside_careers.htm</URL>
                    <URL><![CDATA[http://demo.testfire.net/Privacypolicy.aspx?sec=Careers&template=US]]></URL>
                </ACCESS_PATH>
                <AJAX>false</AJAX>
                <AUTHENTICATION>Not Required</AUTHENTICATION>
                <FIRST_TIME_DETECTED>21 Sep 2017 04:27PM GMT-0400</FIRST_TIME_DETECTED>
                <LAST_TIME_DETECTED>21 Sep 2017 04:27PM GMT-0400</LAST_TIME_DETECTED>
                <LAST_TIME_TESTED>21 Sep 2017 04:27PM GMT-0400</LAST_TIME_TESTED>
                <TIMES_DETECTED>1</TIMES_DETECTED>
                <PAYLOADS>
                    <PAYLOAD>
                        <NUM>1</NUM>
                        <PAYLOAD>aspxerrorpath=%3Cscript%20src%3Dhttp%3A%2F%2Flocalhost%2Fj%20</PAYLOAD>
                        <REQUEST>
                            <METHOD>GET</METHOD>
                            <URL>http://demo.testfire.net/notfound.aspx?aspxerrorpath=%3Cscript%20src%3Dhttp%3A%2F%2Flocalhost%2Fj%20</URL>
                            <HEADERS>
                                <HEADER>
                                    <key>Referer</key>
                                    <value><![CDATA[ http://demo.testfire.net/bank/login.aspx]]></value>
                                </HEADER>
                                <HEADER>
                                    <key>Cookie</key>
                                    <value><![CDATA[ lang=; amSessionId=132271899100; ASP.NET_SessionId=tskomp45ivi55r4530tp5g2a;]]></value>
                                </HEADER>
                            </HEADERS>
                        </REQUEST>
                        <RESPONSE>
                            <CONTENTS base64="true"><![CDATA[Y29tbWVudDogClJlc3BvbnNlIGNvbnRlbnQtdHlwZTogdGV4dC9odG1sCgoNCiAgICA8L3RkPg0K
ICAgIDx0ZCB2YWxpZ249InRvcCIgY29sc3Bhbj0iMyIgY2xhc3M9ImJiIj4NCg0KDQo8ZGl2IGNs
YXNzPSJmbCIgc3R5bGU9IndpZHRoOiA5OSU7Ij4NCg0KPGgxPkFuIEVycm9yIEhhcyBPY2N1cnJl
ZDwvaDE+DQoNCjxwPjxzcGFuIGlkPSJfY3RsMF9fY3RsMF9Db250ZW50X01haW5fZXJyb3IiPkNv
dWxkIG5vdCBmaW5kIHRoZSBwYWdlIHlvdSByZXF1ZXN0ZWQuIDxicj48YnI+PGI+PHNjcmlwdCBz
cmM9aHR0cDovL2xvY2FsaG9zdC9qIDwvYj48YnI+PGJyPlBsZWFzZSBjaGVjayB5b3VyIHNwZWxs
aW5nLiBJZiB0aGUgc3BlbGxpbmcgaXMgY29ycmVjdCBhbmQgdGhlIHBhZ2Ugc3RpbGwgZG9lcyBu
b3QgZXhpc3QgY29udGFjdCB0aGUgU3lzdGVtIEFkbWluaXN0cmF0b3IuPC9zcGFuPjwvcD4NCg0K
PC9kaXY+DQoNCg0KICAgIDwvdGQ+DQogIDwvdHI+DQo8L3RhYmxlPg0KDQoNCjwvZGl2Pg0KDQo8
ZGl2IGlkPSJmb290ZXIiIHN0eWxlPSJ3aWR0aDogOQ==
]]></CONTENTS>
                            <EVIDENCE base64="true"><![CDATA[PHNjcmlwdCBzcmM9aHR0cDovL2xvY2FsaG9zdC9qIDwvYj4=
]]></EVIDENCE>
                        </RESPONSE>
                    </PAYLOAD>
                </PAYLOADS>
                <IGNORED>false</IGNORED>
            </VULNERABILITY>
            <VULNERABILITY>
                <ID>245034753</ID>
                <DETECTION_ID>4293572</DETECTION_ID>
                <QID>150122</QID>
                <URL>http://demo.testfire.net/bank/customize.aspx</URL>
                <AJAX>false</AJAX>
                <AUTHENTICATION>Not Required</AUTHENTICATION>
                <FIRST_TIME_DETECTED>21 Sep 2017 04:27PM GMT-0400</FIRST_TIME_DETECTED>
                <LAST_TIME_DETECTED>21 Sep 2017 04:27PM GMT-0400</LAST_TIME_DETECTED>
                <LAST_TIME_TESTED>21 Sep 2017 04:27PM GMT-0400</LAST_TIME_TESTED>
                <TIMES_DETECTED>1</TIMES_DETECTED>
                <PAYLOADS>
                    <PAYLOAD>
                        <NUM>1</NUM>
                        <PAYLOAD>N/A</PAYLOAD>
                        <REQUEST>
                            <METHOD>GET</METHOD>
                            <URL>http://demo.testfire.net/bank/customize.aspx</URL>
                            <HEADERS/>
                        </REQUEST>
                        <RESPONSE>
                            <CONTENTS base64="true"><![CDATA[bGFuZz07IHBhdGg9LzsgZG9tYWluPWRlbW8udGVzdGZpcmUubmV0
]]></CONTENTS>
                        </RESPONSE>
                    </PAYLOAD>
                </PAYLOADS>
                <IGNORED>false</IGNORED>
            </VULNERABILITY>
        </VULNERABILITY_LIST>
        <INFORMATION_GATHERED_LIST>
            <INFORMATION_GATHERED>
                <ID>245034725</ID>
                <DETECTION_ID>1418269</DETECTION_ID>
                <QID>150086</QID>
                <LAST_TIME_DETECTED>21 Sep 2017 04:27PM GMT-0400</LAST_TIME_DETECTED>
                <DATA base64="true"><![CDATA[U2VydmVyIHJlc3BvbmRlZCAyMDAgdG8gdW5uZWNlc3NhcmlseSBsYXJnZSByYW5kb20gcmVxdWVz
dCBib2R5KG92ZXIgNjQgS0IpIGZvciBVUkwgaHR0cDovL2RlbW8udGVzdGZpcmUubmV0L3NlYXJj
aC5hc3B4LCBzaWduaWZpY2FudGx5IGluY3JlYXNpbmcgYXR0YWNrZXIncyBjaGFuY2VzIHRvIHBy
b2xvbmcgc2xvdyBIVFRQIFBPU1QgYXR0YWNrLg==
]]></DATA>
            </INFORMATION_GATHERED>
        </INFORMATION_GATHERED_LIST>
    </RESULTS>
    <GLOSSARY>
        <QID_LIST>
            <QID>
                <QID>6</QID>
                <CATEGORY>Information Gathered</CATEGORY>
                <SEVERITY>1</SEVERITY>
                <TITLE>DNS Host Name</TITLE>
                <DESCRIPTION>The fully qualified domain name of this host, if it was obtained from a DNS server, is displayed in the RESULT section.</DESCRIPTION>
                <IMPACT></IMPACT>
                <SOLUTION></SOLUTION>
            </QID>
            <QID>
                <QID>150003</QID>
                <CATEGORY>Confirmed Vulnerability</CATEGORY>
                <SEVERITY>5</SEVERITY>
                <TITLE>SQL Injection</TITLE>
                <GROUP>SQL</GROUP>
                <OWASP>A1</OWASP>
                <WASC>WASC-19</WASC>
                <CWE>CWE-89</CWE>
                <CVSS_BASE>10.0</CVSS_BASE>
                <CVSS_TEMPORAL>8.6</CVSS_TEMPORAL>
                <DESCRIPTION><![CDATA[SQL injection enables an attacker to modify the syntax of a SQL query in order to retrieve, corrupt or delete data. This is accomplished by manipulating query criteria in a manner that affects the query's logic. The typical causes of this vulnerability are lack of input validation and insecure construction of the SQL query.
<P>
Queries created by concatenating strings with SQL syntax and user-supplied data are prone to this vulnerability. If any part of the string concatenation can be modified, then the meaning of the query can be changed.
<P>
Examples:
<BR>
These two lines demonstrate an insecure query that is created by appending the user-supplied data (<B>userid</B>):<BR>
<CODE>
dim strQuery as String <BR>
strQuery = "SELECT name,email FROM users WHERE userid=" + Request.QueryString("userid")
</CODE>
<P>
If no checks are performed against the <B>userid</B> parameter, then the query may be arbitrarily modified as shown in these two examples of a completed query:<BR>
<CODE>
SELECT name,email FROM users WHERE userid=<U>42</U><BR>
SELECT name,email FROM users WHERE userid=<U>42; SHUTDOWN WITH NOWAIT</U>
</CODE>]]></DESCRIPTION>
                <IMPACT>The scope of a SQL injection exploit varies greatly. If any SQL statement can be injected into the query, then the attacker has the equivalent access of a database administrator. This access could lead to theft of data, malicious corruption of data, or deletion of data.</IMPACT>
                <SOLUTION><![CDATA[SQL injection vulnerabilities can be addressed in three areas: input validation, query creation, and database security.
<P>
All input received from the Web client should be validated for correct content. If a value's type or content range is known beforehand, then stricter filters should be applied. For example, an email address should be in a specific format and only contain characters that make it a valid address; or numeric fields like a U.S. zip code should be limited to five digit values.
<P>
Prepared statements (sometimes referred to as parameterized statements) provide strong protection from SQL injection. Prepared statements are precompiled SQL queries whose parameters can be modified when the query is executed. Prepared statements enforce the logic of the query and will fail if the query cannot be compiled correctly. Programming languages that support prepared statements provide specific functions for creating queries. These functions are more secure than string concatenation for assigning user-supplied data to a query.
<P>
Stored procedures are precompiled queries that reside in the database. Like prepared statements, they also enforce separation of query data and logic. SQL statements that call stored procedures should not be created via string concatenation, otherwise their security benefits are negated.
<P>
SQL injection exploits can be mitigated by the use of Access Control Lists or role-based access within the database. For example, a read-only account would prevent an attacker from modifying data, but would not prevent the user from viewing unauthorized data. Table and row-based access controls potentially minimize the scope of a compromise, but they do not prevent exploits.
<P>
Example of a secure query created with a prepared statement:
<BR>
<CODE>
PreparedStatement ps = "SELECT name,email FROM users WHERE userid=?";
ps.setInt(1, userid);
</CODE>]]></SOLUTION>
            </QID>
            <QID>
                <QID>150013</QID>
                <CATEGORY>Confirmed Vulnerability</CATEGORY>
                <SEVERITY>5</SEVERITY>
                <TITLE>Browser-Specific Cross-Site Scripting Vulnerabilities</TITLE>
                <GROUP>XSS</GROUP>
                <OWASP>A3</OWASP>
                <WASC>WASC-8</WASC>
                <CWE>CWE-79</CWE>
                <CVSS_BASE>4.3</CVSS_BASE>
                <CVSS_TEMPORAL>4.3</CVSS_TEMPORAL>
                <DESCRIPTION><![CDATA[XSS vulnerabilities occur when the Web application echoes user-supplied data in an HTML response sent to the Web browser. For example, a Web application might include the user's name as part of a welcome message or display a home address when confirming a shipping destination. If the user-supplied data contains characters that are interpreted as part of an HTML element instead of literal text, then an attacker can modify the HTML that is received by the victim's Web browser.
<P>
The XSS payload is echoed in the HTML document returned by the request. An XSS payload may consist of HTML, JavaScript or other content that will be rendered by the browser. In order to exploit this vulnerability, a malicious user would need to trick a victim into visiting the URL with the XSS payload.
<P>
Note! This specific test uses an XSS payload that takes advantage of Mozilla's HTML parsing engine. Manual confirmation of this vulnerability should use the Mozilla browser. Even though this exploits a particular Web browser, the Web application still has inadequate input filters.]]></DESCRIPTION>
                <IMPACT>XSS exploits pose a significant threat to a Web application, its users and user data. XSS exploits target the users of a Web application rather than the Web application itself. An exploit can lead to theft of the user's credentials and personal or financial information. Complex exploits and attack scenarios are possible via XSS because it enables an attacker to execute dynamic code in the victim's Web browser. Consequently, any capability or feature available to the Web browser (for example HTML, JavaScript, Flash, and Java applets) can be used as part of a compromise.</IMPACT>
                <SOLUTION><![CDATA[Filter all data collected from the client including user-supplied content and browser content such as Referrer and User-Agent headers.
<P>
Any data collected from the client and displayed in a Web page should be HTML-encoded to ensure the content is rendered as text instead of an HTML element or JavaScript.]]></SOLUTION>
            </QID>
            <QID>
                <QID>150122</QID>
                <CATEGORY>Confirmed Vulnerability</CATEGORY>
                <SEVERITY>2</SEVERITY>
                <TITLE>Cookie Does Not Contain The "secure" Attribute</TITLE>
                <GROUP>INFO</GROUP>
                <OWASP>A2,A6</OWASP>
                <CVSS_BASE>6.4</CVSS_BASE>
                <CVSS_TEMPORAL>5.8</CVSS_TEMPORAL>
                <DESCRIPTION><![CDATA[The cookie does not contain the "secure" attribute.
]]></DESCRIPTION>
                <IMPACT>Cookies with the "secure" attribute are only permitted to be sent via HTTPS. Cookies sent via HTTP expose an unsuspecting user to sniffing attacks that could lead to user impersonation or compromise of the application account.</IMPACT>
                <SOLUTION>If the associated risk of a compromised account is high, apply the "secure" attribute to cookies and force all sensitive requests to be sent via HTTPS.</SOLUTION>
            </QID>
        </QID_LIST>
        <GROUP_LIST>
            <GROUP>
                <CODE>PATH</CODE>
                <NAME>Path Disclosure</NAME>
                <TYPE>VULNERABILITY</TYPE>
            </GROUP>
            <GROUP>
                <CODE>CC</CODE>
                <NAME>Credit Card Numbers</NAME>
                <TYPE>SENSITIVE_CONTENT</TYPE>
            </GROUP>
        </GROUP_LIST>
        <OWASP_LIST>
            <OWASP>
                <CODE>A1</CODE>
                <NAME>Injection</NAME>
            </OWASP>
            <OWASP>
                <CODE>A2</CODE>
                <NAME>Broken Authentication and Session Management</NAME>
            </OWASP>
        </OWASP_LIST>
        <WASC_LIST>
            <WASC>
                <CODE>WASC-1</CODE>
                <NAME>Insufficient Authentication</NAME>
            </WASC>
            <WASC>
                <CODE>WASC-2</CODE>
                <NAME>Insufficient Authorization</NAME>
            </WASC>
        </WASC_LIST>
    </GLOSSARY>
    <APPENDIX>
        <SCAN_LIST>
            <SCAN>
                <NAME>Demo Vul Scan</NAME>
                <REFERENCE>was/1506025640903.17017983</REFERENCE>
                <START_DATE>21 Sep 2017 04:27PM GMT-0400</START_DATE>
                <END_DATE>21 Sep 2017 04:47PM GMT-0400</END_DATE>
                <MODE>Vulnerability</MODE>
                <TYPE>Manual</TYPE>
                <WEB_APPLICATION>Vulnerable Web APP</WEB_APPLICATION>
                <AUTHENTICATION_RECORD>None</AUTHENTICATION_RECORD>
                <PROFILE>Vulnerable Web APP option</PROFILE>
                <SCANNER>External (IP: 64.39.99.98, Scanner: 9.6.19-1, WAS: 4.3.87-1, Signatures: 2.4.146-2)</SCANNER>
                <STATUS>Finished</STATUS>
                <AUTHENTICATION_STATUS>No Authentication specified</AUTHENTICATION_STATUS>
            </SCAN>
        </SCAN_LIST>
        <WEBAPP>
            <ID>58651486</ID>
            <NAME>Vulnerable Web APP</NAME>
            <URL>http://demo.testfire.net/bank/login.aspx</URL>
            <OPERATING_SYSTEM>Windows Vista / Windows 2008 / Windows 7 / Windows 2012</OPERATING_SYSTEM>
            <SCOPE>Limit to URL hostname</SCOPE>
        </WEBAPP>
        <SEVERITY_CATEGORY_LIST>
            <SEVERITY_CATEGORY>
                <NAME>Confirmed Vulnerability</NAME>
                <DESCRIPTION>Vulnerabilities (QIDs) are design flaws, programming errors, or mis-configurations that make your web application and web application platform susceptible to malicious attacks. Depending on the level of the security risk, the successful exploitation of a vulnerability can vary from the disclosure of information to a complete compromise of the web application and/or the web application platform. Even if the web application isn't fully compromised, an exploited vulnerability could still lead to the web application being used to launch attacks against users of the site.</DESCRIPTION>
                <SEVERITY_LEVEL_LIST>
                    <SEVERITY_LEVEL>
                        <SEVERITY>1</SEVERITY>
                        <LEVEL>Minimal</LEVEL>
                        <DESCRIPTION>Basic information disclosure (e.g. web server type, programming language) might enable intruders to discover other vulnerabilities, but lack of this information does not make the vulnerability harder to find.</DESCRIPTION>
                    </SEVERITY_LEVEL>
                    <SEVERITY_LEVEL>
                        <SEVERITY>2</SEVERITY>
                        <LEVEL>Medium</LEVEL>
                        <DESCRIPTION>Intruders may be able to collect sensitive information about the application platform, such as the precise version of software used. With this information, intruders can easily exploit known vulnerabilities specific to software versions. Other types of sensitive information might disclose a few lines of source code or hidden directories.</DESCRIPTION>
                    </SEVERITY_LEVEL>
                </SEVERITY_LEVEL_LIST>
            </SEVERITY_CATEGORY>
            <SEVERITY_CATEGORY>
                <NAME>Potential Vulnerability</NAME>
                <DESCRIPTION>Potential Vulnerabilities indicate that the scanner observed a weakness or error that is commonly used to attack a web application, and the scanner was unable to confirm if the weakness or error could be exploited. Where possible, the QID's description and results section include information and hints for following-up with manual analysis. For example, the exploitability of a QID may be influenced by characteristics that the scanner cannot confirm, such as the web application's network architecture, or the test to confirm exploitability requires more intrusive testing than the scanner is designed to conduct.</DESCRIPTION>
                <SEVERITY_LEVEL_LIST>
                    <SEVERITY_LEVEL>
                        <SEVERITY>1</SEVERITY>
                        <LEVEL>Minimal</LEVEL>
                        <DESCRIPTION>Presence of this vulnerability is indicative of basic information disclosure (e.g. web server type, programming language) and might enable intruders to discover other vulnerabilities. For example in this scenario, information such as web server type, programming language, passwords or file path references can be disclosed.</DESCRIPTION>
                    </SEVERITY_LEVEL>
                </SEVERITY_LEVEL_LIST>
            </SEVERITY_CATEGORY>
        </SEVERITY_CATEGORY_LIST>
    </APPENDIX>
</WAS_SCAN_REPORT>
"""

class Args:
    pass

def test_qualysweb():
    xmldict = xmltodict.parse(qualysweb_testfile, xml_attribs=True)
    qualys = dast.detect_input_type(xmldict)
    vulnerability_data = qualys.handle(xmldict)
    assert vulnerability_data is not None
    args = Args()
    args.filename = "/path/to/testfile.xml"
    args.group = "qualysweb"
    psmgroup = dast.new_psmgroup(args, "qualysweb", vulnerability_data)
    assert psmgroup["name"] == "qualysweb"
    assert psmgroup["hit_action"] == "WAF_ACTION_NO_OP"
    assert psmgroup["miss_action"] == "WAF_ACTION_BLOCK"

    assert len(psmgroup["locations"]) == 2
    expected_location_urls = {"/bank/login.aspx", "/notfound.aspx"}
    # expected_rules location_url ->rule_regex
    expected_rules = {
        "/bank/login.aspx": "^[A-Za-z0-9_:/?!@#&=+-]*$",
        "/notfound.aspx": "^[A-Za-z0-9 \t,._/:;|?!@#$%&=-]*$"}
    expected_params = {
        "/bank/login.aspx": "passw",
        "/notfound.aspx": "aspxerrorpath"}
    for loc in psmgroup["locations"]:
        assert loc["match"]["path"]["match_case"] == "INSENSITIVE"
        assert loc["match"]["path"]["match_criteria"] == "EQUALS"
        assert len(loc["match"]["path"]["match_str"]) == 1
        assert loc["match"]["path"]["match_str"][0] == loc["name"]
        assert loc["match"]["path"]["match_str"][0] in expected_location_urls
        expected_location_urls.remove(loc["match"]["path"]["match_str"][0])
        for rule in loc["rules"]:
            assert rule["match_value_pattern"] == expected_rules[loc["name"]]
            assert rule["match_case"] == "SENSITIVE"
            assert len(rule["match_elements"]) == 1
            assert rule["match_elements"][0]["name"] == "WAF_VARIABLE_ARGS"
            assert rule["match_elements"][0]["sub_element"] == expected_params[loc["name"]]
    assert len(expected_location_urls) == 0, "Not all locations parsed from the file"



zap1_testfile = """<?xml version="1.0" encoding="UTF-8"?>
<OWASPZAPReport generated="Fri, 4 Oct 2013 15:17:03" version="1.4.0.1">
<site host="10.2.100.1" name="http://10.2.100.1" port="80" ssl="false">
<alerts>
<alertitem>
  <pluginid>10021</pluginid>
  <alert>X-Content-Type-Options header missing</alert>
  <riskcode>1</riskcode>
  <reliability>2</reliability>
  <riskdesc>Low (Warning)</riskdesc>
  <desc>The Anti-MIME-Sniffing header X-Content-Type-Options was not set to 'nosniff'
	</desc>
  <uri>http://10.2.100.1/</uri>
  <param/>
  <attack/>
  <otherinfo/>
  <solution>blah
	</solution>
  <reference>
	</reference>
</alertitem>
<alertitem>
  <pluginid>40004</pluginid>
  <alert>SQL Injection Fingerprinting</alert>
  <riskcode>3</riskcode>
  <reliability>1</reliability>
  <riskdesc>High (Suspicious)</riskdesc>
  <desc>SQL injection may be possible.
	</desc>
  <uri>http://10.2.100.1/demo/SQLI2.php</uri>
  <param>username</param>
  <attack>1'INJECTED_PARAM</attack>
  <otherinfo>SQL</otherinfo>
  <solution>blah
	</solution>
  <otherinfo>SQL
	</otherinfo>
  <reference>The OWASP guide at http://www.owasp.org/documentation/guide
	http://www.sqlsecurity.com/DesktopDefault.aspx?tabid=23
	http://www.spidynamics.com/whitepapers/WhitepaperSQLInjection.pdf
	For Oracle database, refer to http://www.integrigy.com/info/IntegrigyIntrotoSQLInjectionAttacks.pdf

	</reference>
</alertitem>
<alertitem>
  <pluginid>40012</pluginid>
  <alert>Cross Site Scripting</alert>
  <riskcode>3</riskcode>
  <reliability>2</reliability>
  <riskdesc>High (Warning)</riskdesc>
  <desc>blah
	</desc>
  <uri>http://10.2.100.1/demo/XSS-reflected2.php</uri>
  <param>username</param>
  <attack>&lt;script&gt;alert(1);&lt;/script&gt;</attack>
  <otherinfo/>
  <solution>blah
	</solution>
  <reference>http://projects.webappsec.org/Cross-Site-Scripting
	http://cwe.mitre.org/data/definitions/79.html
	</reference>
</alertitem>
</alerts><portscan/></site></OWASPZAPReport>
"""


def test_zap1():
    xmldict = xmltodict.parse(zap1_testfile, xml_attribs=True)
    zap = dast.detect_input_type(xmldict)
    vulnerability_data = zap.handle(xmldict)
    assert vulnerability_data is not None
    args = Args()
    args.filename = "/path/to/testfile.xml"
    args.group = "zap"
    psmgroup = dast.new_psmgroup(args, "zap", vulnerability_data)
    assert psmgroup["name"] == "zap"
    assert psmgroup["hit_action"] == "WAF_ACTION_NO_OP"
    assert psmgroup["miss_action"] == "WAF_ACTION_BLOCK"

    assert len(psmgroup["locations"]) == 2
    expected_location_urls = {"/demo/SQLI2.php", "/demo/XSS-reflected2.php"}
    # expected_rules location_url ->rule_regex
    expected_rules = {
        "/demo/SQLI2.php": "^[A-Za-z0-9_:/?!@#&=+-]*$",
        "/demo/XSS-reflected2.php": "^[A-Za-z0-9 \t,._/:;|?!@#$%&=-]*$"}
    expected_params = {
        "/demo/SQLI2.php": "username",
        "/demo/XSS-reflected2.php": "username"}
    for loc in psmgroup["locations"]:
        assert loc["match"]["path"]["match_case"] == "INSENSITIVE"
        assert loc["match"]["path"]["match_criteria"] == "EQUALS"
        assert len(loc["match"]["path"]["match_str"]) == 1
        assert loc["match"]["path"]["match_str"][0] == loc["name"]
        assert loc["match"]["path"]["match_str"][0] in expected_location_urls
        expected_location_urls.remove(loc["match"]["path"]["match_str"][0])
        for rule in loc["rules"]:
            assert rule["match_value_pattern"] == expected_rules[loc["name"]]
            assert rule["match_case"] == "SENSITIVE"
            assert len(rule["match_elements"]) == 1
            assert rule["match_elements"][0]["name"] == "WAF_VARIABLE_ARGS"
            assert rule["match_elements"][0]["sub_element"] == expected_params[loc["name"]]
    assert len(expected_location_urls) == 0, "Not all locations parsed from the file"


zap2_testfile = """<?xml version="1.0"?>
<OWASPZAPReport version="2.8.0" generated="Sat, 21 Sep 2019 20:36:21">
<site name="http://10.151.20.109:8888" host="10.151.20.109" port="8888" ssl="false">
<alerts>
<alertitem>
  <pluginid>10202</pluginid>
  <alert>Absence of Anti-CSRF Tokens</alert>
  <name>Absence of Anti-CSRF Tokens</name>
  <riskcode>1</riskcode>
  <confidence>2</confidence>
  <riskdesc>Low (Medium)</riskdesc>
  <desc>blah</desc>
  <instances>
  <instance>
  <uri>http://10.151.20.109:8888/product/view?id=4</uri>
  <method>GET</method>
  <evidence>&lt;form id=&quot;cart_form&quot; action=&quot;/cart/add&quot; method=&quot;post&quot; class=&quot;form-horizontal&quot; role=&quot;form&quot;&gt;</evidence>
  </instance>
  <instance>
  <uri>http://10.151.20.109:8888/wishlist/view/&apos;%20+%20data%5Bi%5D.wishLists%5Bj%5D.id%20+%20&apos;</uri>
  <method>GET</method>
  <evidence>&lt;form role=&quot;form&quot; method=&quot;post&quot; class=&quot;signin&quot; action=&quot;/user/login&quot; id=&quot;loginForm&quot;&gt;</evidence>
  </instance>
  </instances>
  <count>1029</count>
  <solution>blah</solution>
  <otherinfo>blah</otherinfo>
  <reference>&lt;p&gt;http://projects.webappsec.org/Cross-Site-Request-Forgery&lt;/p&gt;&lt;p&gt;http://cwe.mitre.org/data/definitions/352.html&lt;/p&gt;</reference>
  <cweid>352</cweid>
  <wascid>9</wascid>
  <sourceid>3</sourceid>
</alertitem>
<alertitem>
  <pluginid>40012</pluginid>
  <alert>Cross Site Scripting (Reflected)</alert>
  <name>Cross Site Scripting (Reflected)</name>
  <riskcode>3</riskcode>
  <confidence>2</confidence>
  <riskdesc>High (Medium)</riskdesc>
  <desc>blah</desc>
  <instances>
  <instance>
  <uri>http://10.151.20.109:8888/search?id=&amp;searchString=%3C%2Ftitle%3E%3Cscript%3Ealert%281%29%3B%3C%2Fscript%3E%3Ctitle%3E</uri>
  <method>GET</method>
  <param>searchString</param>
  <attack>&lt;/title&gt;&lt;script&gt;alert(1);&lt;/script&gt;&lt;title&gt;</attack>
  <evidence>&lt;/title&gt;&lt;script&gt;alert(1);&lt;/script&gt;&lt;title&gt;</evidence>
  </instance>
  </instances>
  <count>1</count>
  <solution>blah</solution>
  <reference>&lt;p&gt;http://projects.webappsec.org/Cross-Site-Scripting&lt;/p&gt;&lt;p&gt;http://cwe.mitre.org/data/definitions/79.html&lt;/p&gt;</reference>
  <cweid>79</cweid>
  <wascid>8</wascid>
  <sourceid>1</sourceid>
</alertitem>
<alertitem>
  <pluginid>40018</pluginid>
  <alert>SQL Injection</alert>
  <name>SQL Injection</name>
  <riskcode>3</riskcode>
  <confidence>2</confidence>
  <riskdesc>High (Medium)</riskdesc>
  <desc>&lt;p&gt;SQL injection may be possible.&lt;/p&gt;</desc>
  <instances>
  <instance>
  <uri>http://10.151.20.109:8888/review/send</uri>
  <method>POST</method>
  <param>textReview</param>
  <attack> OR 1=1 -- </attack>
  </instance>
  <instance>
  <uri>http://10.151.20.109:8888/category/view?id=3%27+AND+%271%27%3D%271%27+--+</uri>
  <method>GET</method>
  <param>id</param>
  <attack>3&apos; AND &apos;1&apos;=&apos;1&apos; -- </attack>
  </instance>
  </instances>
  <count>4</count>
  <solution>blah</solution>
  <otherinfo>blah</otherinfo>
  <reference>&lt;p&gt;https://www.owasp.org/index.php/Top_10_2010-A1&lt;/p&gt;&lt;p&gt;https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet&lt;/p&gt;</reference>
  <cweid>89</cweid>
  <wascid>19</wascid>
  <sourceid>1</sourceid>
</alertitem>
</alerts></site></OWASPZAPReport>
"""


def test_zap2():
    xmldict = xmltodict.parse(zap2_testfile, xml_attribs=True)
    zap = dast.detect_input_type(xmldict)
    vulnerability_data = zap.handle(xmldict)
    assert vulnerability_data is not None
    args = Args()
    args.filename = "/path/to/testfile.xml"
    args.group = "zap"
    psmgroup = dast.new_psmgroup(args, "zap", vulnerability_data)
    assert psmgroup["name"] == "zap"
    assert psmgroup["hit_action"] == "WAF_ACTION_NO_OP"
    assert psmgroup["miss_action"] == "WAF_ACTION_BLOCK"

    assert len(psmgroup["locations"]) == 3
    expected_location_urls = {"/search", "/review/send", "/category/view"}
    # expected_rules location_url ->rule_regex
    expected_rules = {
        "/search": "^[A-Za-z0-9 \t,._/:;|?!@#$%&=-]*$",
        "/review/send": "^[A-Za-z0-9_:/?!@#&=+-]*$",
        "/category/view": "^[A-Za-z0-9_:/?!@#&=+-]*$"}
    expected_params = {
        "/search": "searchString",
        "/review/send": "textReview",
        "/category/view": "id"}
    for loc in psmgroup["locations"]:
        assert loc["match"]["path"]["match_case"] == "INSENSITIVE"
        assert loc["match"]["path"]["match_criteria"] == "EQUALS"
        assert len(loc["match"]["path"]["match_str"]) == 1
        assert loc["match"]["path"]["match_str"][0] == loc["name"]
        assert loc["match"]["path"]["match_str"][0] in expected_location_urls
        expected_location_urls.remove(loc["match"]["path"]["match_str"][0])
        for rule in loc["rules"]:
            assert rule["match_value_pattern"] == expected_rules[loc["name"]]
            assert rule["match_case"] == "SENSITIVE"
            assert len(rule["match_elements"]) == 1
            assert rule["match_elements"][0]["name"] == "WAF_VARIABLE_ARGS"
            assert rule["match_elements"][0]["sub_element"] == expected_params[loc["name"]]
    assert len(expected_location_urls) == 0, "Not all locations parsed from the file"
