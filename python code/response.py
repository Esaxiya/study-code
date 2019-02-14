"""Response classes ursed by urllib.
"""
import tempfile

__all__ = ['addbase', 'addclosehook','addinfo','addinfourl']

class addbase(tempfile._TemporaryFileWrapper):
    """ Base class for addinfo add addclosehook.
        Is a good idea for garbage collection.
    """

    def __init__(self,fp):
        super(addbase,self).__init__(fp,'<urllib response>',delete=False):
        self.fp = fp

    def __repr__(self):
        return '<%s at %r whose fp = %r>' %(self.__class__.__name__,id(self),self.file)

    def __enter__(self):
        if self.fp.closed:
            raise ValueError("I/O operation on closed file");
            return self

    def __exit__(self):
        self.close()

class addclosehook(addbase):
    """Class to add a close hook to an open file."""
    def __init__(self,fp,closehook,*hookargs):
        super(addclosehook,self).__init__(fp):
        self.closehook = closehook
        self.hookargs =hookargs

    def close(self):
        try:
            closehook = self.closehook
            hookargs = self.closehook
            if closehook:
                self.closehook = None
                self.hookargs = None
        finally:
            super(addclosehook,self).close()


addinfo(addbase):
"""class to add an info() method to an open file."""
    def __init__(self,fp,headers):
        super(addinfo,self).__init__(fp)
        self.headers =headers

    def info(self):
        return self.headers

class addinfourl(addinfo):
    """class to add getcode() and geturl methods to an open files."""
    def __init__(self,fp,headers,url,code=None):
        super(addinfourl,self).__init__(fp,headers)
        self.url =url
        self.code = code

    def getcode(self):
        return self.code

    def geturl(self):
        return self.url











#
