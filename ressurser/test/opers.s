# Code file created by Pascal2016 compiler 2016-11-29 13:13:22
        .globl  _main                   
_main:
        call    prog$operatortest_1     # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$operatortest_1:
        enter   $32,$1                  # Start of operatortest
proc$testunaryboolean_2:
        enter   $-32,$1                 # Start of testunaryboolean
proc$test_3:
        enter   $-28,$2                 # Start of test
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        xorl    $1,%eax                 # Negation side 49
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 8
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 8
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 8
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 8
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $116,%eax               #   't' Skrevet ut i: <char literal> on line 8
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $111,%eax               #   'o' Skrevet ut i: <char literal> on line 8
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $110,%eax               #   'n' Skrevet ut i: <char literal> on line 8
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of test
        ret                             
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push next param.
        call    proc$test_3             # Proc call
        addl    $4,%esp                 # Pop param.
        movl    $1,%eax                 #   1
        pushl   %eax                    # Push next param.
        call    proc$test_3             # Proc call
        addl    $4,%esp                 # Pop param.
        leave                           # End of testunaryboolean
        ret                             
proc$testbinaryboolean_4:
        enter   $-32,$1                 # Start of testbinaryboolean
proc$test_5:
        enter   $-24,$2                 # Start of test
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
                                        #  and : Ikke implementert. Factor Opr
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $100,%eax               #   'd' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $110,%eax               #   'n' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $97,%eax                #   'a' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
                                        #  > : Ikke implementert. Term Opr
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 21
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 21
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 21
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 21
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $114,%eax               #   'r' Skrevet ut i: <char literal> on line 21
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $111,%eax               #   'o' Skrevet ut i: <char literal> on line 21
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 21
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        leave                           # End of test
        ret                             
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push next param.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push next param.
        call    proc$test_5             # Proc call
        addl    $8,%esp                 # Pop param.
        movl    $1,%eax                 #   1
        pushl   %eax                    # Push next param.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push next param.
        call    proc$test_5             # Proc call
        addl    $8,%esp                 # Pop param.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push next param.
        movl    $1,%eax                 #   1
        pushl   %eax                    # Push next param.
        call    proc$test_5             # Proc call
        addl    $8,%esp                 # Pop param.
        movl    $1,%eax                 #   1
        pushl   %eax                    # Push next param.
        movl    $1,%eax                 #   1
        pushl   %eax                    # Push next param.
        call    proc$test_5             # Proc call
        addl    $8,%esp                 # Pop param.
        leave                           # End of testbinaryboolean
        ret                             
proc$testunarynumeric_6:
        enter   $-32,$1                 # Start of testunarynumeric
proc$test_7:
        enter   $-28,$2                 # Start of test
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        negl    %eax                    #   - (prefix)
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 34
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 34
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 34
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 34
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $45,%eax                #   '-' Skrevet ut i: <char literal> on line 34
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 35
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 35
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 35
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 35
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $43,%eax                #   '+' Skrevet ut i: <char literal> on line 35
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of test
        ret                             
        movl    $17,%eax                #   17 Skrevet ut i: <number literal> on line 39
        pushl   %eax                    # Push next param.
        call    proc$test_7             # Proc call
        addl    $4,%esp                 # Pop param.
        negl    %eax                    #   - (prefix)
        movl    $11,%eax                #   11 Skrevet ut i: <number literal> on line 39
        pushl   %eax                    # Push next param.
        call    proc$test_7             # Proc call
        addl    $4,%esp                 # Pop param.
        movl    $0,%eax                 #   0 Skrevet ut i: <number literal> on line 39
        pushl   %eax                    # Push next param.
        call    proc$test_7             # Proc call
        addl    $4,%esp                 # Pop param.
        leave                           # End of testunarynumeric
        ret                             
proc$testbinarynumeric_8:
        enter   $-32,$1                 # Start of testbinarynumeric
proc$test_9:
        enter   $-24,$2                 # Start of test
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #    +
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 47
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 47
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 47
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 47
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $43,%eax                #   '+' Skrevet ut i: <char literal> on line 47
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 47
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        movl    %eax,%ecx               
        popl    %eax                    
        subl    %ecx,%eax               #    -
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 48
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 48
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 48
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 48
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $45,%eax                #   '-' Skrevet ut i: <char literal> on line 48
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 48
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
                                        #  * : Ikke implementert. Factor Opr
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 49
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 49
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 49
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 49
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $42,%eax                #   '*' Skrevet ut i: <char literal> on line 49
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 49
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
                                        #  <> : Ikke implementert. Rel Opr
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0010                  # Jump to .L0010
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        movl    %eax,%ecx               # --simple expr: div
        popl    %eax                    # --simple expr: div
        cdq                             # --simple expr: div
        idivl   %ecx                    # --simple expr: div
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 51
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 51
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 51
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 51
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $118,%eax               #   'v' Skrevet ut i: <char literal> on line 51
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $105,%eax               #   'i' Skrevet ut i: <char literal> on line 51
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $100,%eax               #   'd' Skrevet ut i: <char literal> on line 51
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 51
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
                                        #  mod : Ikke implementert. Factor Opr
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 52
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 52
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 52
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 52
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $100,%eax               #   'd' Skrevet ut i: <char literal> on line 52
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $111,%eax               #   'o' Skrevet ut i: <char literal> on line 52
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $109,%eax               #   'm' Skrevet ut i: <char literal> on line 52
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' ' Skrevet ut i: <char literal> on line 52
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
.L0010:
        leave                           # End of test
        ret                             
        movl    $17,%eax                #   17 Skrevet ut i: <number literal> on line 57
        pushl   %eax                    # Push next param.
        movl    $17,%eax                #   17 Skrevet ut i: <number literal> on line 57
        pushl   %eax                    # Push next param.
        call    proc$test_9             # Proc call
        addl    $8,%esp                 # Pop param.
        negl    %eax                    #   - (prefix)
        movl    $11,%eax                #   11 Skrevet ut i: <number literal> on line 57
        pushl   %eax                    # Push next param.
        movl    $17,%eax                #   17 Skrevet ut i: <number literal> on line 57
        pushl   %eax                    # Push next param.
        call    proc$test_9             # Proc call
        addl    $8,%esp                 # Pop param.
        movl    $0,%eax                 #   0 Skrevet ut i: <number literal> on line 57
        pushl   %eax                    # Push next param.
        movl    $17,%eax                #   17 Skrevet ut i: <number literal> on line 57
        pushl   %eax                    # Push next param.
        call    proc$test_9             # Proc call
        addl    $8,%esp                 # Pop param.
        movl    $17,%eax                #   17 Skrevet ut i: <number literal> on line 58
        pushl   %eax                    # Push next param.
        negl    %eax                    #   - (prefix)
        movl    $11,%eax                #   11 Skrevet ut i: <number literal> on line 58
        pushl   %eax                    # Push next param.
        call    proc$test_9             # Proc call
        addl    $8,%esp                 # Pop param.
        negl    %eax                    #   - (prefix)
        movl    $11,%eax                #   11 Skrevet ut i: <number literal> on line 58
        pushl   %eax                    # Push next param.
        negl    %eax                    #   - (prefix)
        movl    $11,%eax                #   11 Skrevet ut i: <number literal> on line 58
        pushl   %eax                    # Push next param.
        call    proc$test_9             # Proc call
        addl    $8,%esp                 # Pop param.
        movl    $0,%eax                 #   0 Skrevet ut i: <number literal> on line 58
        pushl   %eax                    # Push next param.
        movl    $17,%eax                #   17 Skrevet ut i: <number literal> on line 58
        pushl   %eax                    # Push next param.
        call    proc$test_9             # Proc call
        addl    $8,%esp                 # Pop param.
        movl    $17,%eax                #   17 Skrevet ut i: <number literal> on line 59
        pushl   %eax                    # Push next param.
        movl    $0,%eax                 #   0 Skrevet ut i: <number literal> on line 59
        pushl   %eax                    # Push next param.
        call    proc$test_9             # Proc call
        addl    $8,%esp                 # Pop param.
        negl    %eax                    #   - (prefix)
        movl    $11,%eax                #   11 Skrevet ut i: <number literal> on line 59
        pushl   %eax                    # Push next param.
        movl    $0,%eax                 #   0 Skrevet ut i: <number literal> on line 59
        pushl   %eax                    # Push next param.
        call    proc$test_9             # Proc call
        addl    $8,%esp                 # Pop param.
        movl    $0,%eax                 #   0 Skrevet ut i: <number literal> on line 59
        pushl   %eax                    # Push next param.
        movl    $0,%eax                 #   0 Skrevet ut i: <number literal> on line 59
        pushl   %eax                    # Push next param.
        call    proc$test_9             # Proc call
        addl    $8,%esp                 # Pop param.
        leave                           # End of testbinarynumeric
        ret                             
        leave                           # End of operatortest
        ret                             
