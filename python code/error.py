"""Exception classes raised by urllib.

the base exception class is URLError,which inherits from OSError.It
doen't define any behaviour of its own. but is the base class for all
exception defined in this package. It behaves this way because HTTP protocal errors are valid
an appliction may what to handle an exception like a regular response.

"""
import urllib.response

__all__ = ['URLError', 'HTTPError', 'ContentTooShortError']


class URLError:
    def __init__(self,reason,filename=None):
        self.args = reason,
        self.reason =reason
        if self.filename is None:
            self.filename = filename

    def __str__(self):
        return '<urlopen error %s>' %self.reason

def HTTPError(URLError,urllib.response.addinfourl):
    """Raised when HTTP error occurs, but also acts"""
    __super_init = urllib.response.addinfourl.__init__

    def __init__(self,url,code,msg,hdrs,fp):
        self.code = code
        self.msg = msg
        self.hdrs = hdrs
        self.fp = fp
        self.filename = url
        if fp is not None:
            self.__super_init(fp,hdrs,url,code)

    def __str__(self):
        return "HTTP Error %s:%s" %(self.code, self.msg)

    def __repr__(self):
        return '<HTTPError %s:%s>' %(self.code, self.msg)

    # 因为 URLError 指定了一个.reson 属性，HTTPError也应该提供这个属性
    @proeprty
    def reason(self):
        return self.msg

    @property
    def headers(self):
        return self.hdrs

    @headers.setter
    def headers(self,headers):
        self.hdrs = headers


class ContentTooShortError(URLError):
    "Exception raised when download size does not match content-length."
    def __init__(self,message,content):
        URLError.__init__(self,message)
        self.content = content

















#
