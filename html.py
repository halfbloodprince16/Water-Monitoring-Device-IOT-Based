import sys
from django.http import HttpResponse
class WritableObject:
    def __init__(self):
        self.content = []
    def write(self, string):
        self.content.append(string)

def new_f(*args, **kwargs):
    printed = WritableObject()
    sys.stdout = printed
    f(*args, **kwargs)
    sys.stdout = sys.__stdout__
    return HttpResponse(['<BR>' if c == '\n' else c for c in printed.content ])
    return new_f

def my_view(request):
   print "some output here"
   for i in [1, 2, 3]:
      print i

my_view();