CC            = /usr/bin/g++
CPPFLAGS      = -g -c
LDFLAGS       = -g
OMNI_HOME     = /usr/local
OMNI_INCLUDES = -I$(OMNI_HOME)/include
OMNI_LIB_DIR  = $(OMNI_HOME)/lib
OMNIIDL       = $(OMNI_HOME)/bin/omniidl
INCLUDES      = $(OMNI_INCLUDES)
LIBS          = -lomniORB4 -lomnithread -lomniDynamic4
OBJECTS       = echoSK.o eg3_clt.o

all eg3_clt: $(OBJECTS)
	$(CC) $(LDFLAGS) -o eg3_clt eg3_clt.o echoSK.o $(LIBS)

eg3_clt.o: eg3_clt.cc
	$(CC) $(CPPFLAGS) eg3_clt.cc -I.

echoSK.o: echoSK.cc echo.hh
	$(CC) $(CPPFLAGS) echoSK.cc -I.

echoSK.cc: echo.idl
	$(OMNIIDL) -bcxx echo.idl

clean clean_all:
	rm -fr *.o
	rm -fr *.hh
	rm -fr *SK.cc
	rm -fr Client
