# Code file created by Pascal2016 compiler 2016-11-25 13:21:17
        .globl  main                    
main:
        call    prog$operatortest_1     # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$operatortest_1:
        enter   $32,$1                  # Start of operatortest
        enter   $32,$1                  # Start of BLANK
        enter   $32,$1                  # Start of BLANK
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        xorl    $1,%eax                 # Negation side 49
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $116,%eax               #   't'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $111,%eax               #   'o'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $110,%eax               #   'n'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of BLANK
        ret                             
proc$test_81:
        enter   $32,$2                  # Start of test
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_81            # Proc call
        addl    $4,%esp                 # Pop param.
proc$test_88:
        enter   $32,$2                  # Start of test
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_88            # Proc call
        addl    $4,%esp                 # Pop param.
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        enter   $32,$1                  # Start of BLANK
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $100,%eax               #   'd'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $110,%eax               #   'n'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $97,%eax                #   'a'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $114,%eax               #   'r'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $111,%eax               #   'o'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_bool              
        addl    $4,%esp                 # Pop param.
        leave                           # End of BLANK
        ret                             
proc$test_263:
        enter   $32,$2                  # Start of test
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_263           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_276:
        enter   $32,$2                  # Start of test
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_276           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_289:
        enter   $32,$2                  # Start of test
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_289           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_302:
        enter   $32,$2                  # Start of test
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_302           # Proc call
        addl    $8,%esp                 # Pop param.
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        enter   $32,$1                  # Start of BLANK
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        negl    %eax                    #   -
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $45,%eax                #   '-'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $43,%eax                #   '+'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of BLANK
        ret                             
proc$test_431:
        enter   $32,$2                  # Start of test
        movl    $17,%eax                #   17
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_431           # Proc call
        addl    $4,%esp                 # Pop param.
proc$test_438:
        enter   $32,$2                  # Start of test
        negl    %eax                    #   -
        movl    $11,%eax                #   11
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_438           # Proc call
        addl    $4,%esp                 # Pop param.
proc$test_447:
        enter   $32,$2                  # Start of test
        movl    $0,%eax                 #   0
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_447           # Proc call
        addl    $4,%esp                 # Pop param.
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        enter   $32,$1                  # Start of BLANK
        pushl   %eax                    
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
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $43,%eax                #   '+'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $45,%eax                #   '-'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $42,%eax                #   '*'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        movl    $0,%eax                 #   0
        pushl   %eax                    
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0669                  # Jump to .L0669
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $118,%eax               #   'v'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $105,%eax               #   'i'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $100,%eax               #   'd'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $100,%eax               #   'd'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $111,%eax               #   'o'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $109,%eax               #   'm'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $32,%eax                #   ' '
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
.L0669:
                                        # ?
.L0670:
                                        # ??
        leave                           # End of BLANK
        ret                             
proc$test_845:
        enter   $32,$2                  # Start of test
        movl    $17,%eax                #   17
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        movl    $17,%eax                #   17
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_845           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_858:
        enter   $32,$2                  # Start of test
        negl    %eax                    #   -
        movl    $11,%eax                #   11
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        movl    $17,%eax                #   17
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_858           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_873:
        enter   $32,$2                  # Start of test
        movl    $0,%eax                 #   0
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        movl    $17,%eax                #   17
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_873           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_886:
        enter   $32,$2                  # Start of test
        movl    $17,%eax                #   17
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        negl    %eax                    #   -
        movl    $11,%eax                #   11
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_886           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_901:
        enter   $32,$2                  # Start of test
        negl    %eax                    #   -
        movl    $11,%eax                #   11
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        negl    %eax                    #   -
        movl    $11,%eax                #   11
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_901           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_918:
        enter   $32,$2                  # Start of test
        movl    $0,%eax                 #   0
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        movl    $17,%eax                #   17
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_918           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_931:
        enter   $32,$2                  # Start of test
        movl    $17,%eax                #   17
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        movl    $0,%eax                 #   0
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_931           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_944:
        enter   $32,$2                  # Start of test
        negl    %eax                    #   -
        movl    $11,%eax                #   11
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        movl    $0,%eax                 #   0
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_944           # Proc call
        addl    $8,%esp                 # Pop param.
proc$test_959:
        enter   $32,$2                  # Start of test
        movl    $0,%eax                 #   0
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        movl    $0,%eax                 #   0
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    proc$test_959           # Proc call
        addl    $8,%esp                 # Pop param.
        leave                           # End of BLANK
        ret                             
proc$testunaryboolean_974:
        enter   $32,$1                  # Start of testunaryboolean
proc$testunarynumeric_975:
        enter   $32,$1                  # Start of testunarynumeric
proc$testbinaryboolean_976:
        enter   $32,$1                  # Start of testbinaryboolean
proc$testbinarynumeric_977:
        enter   $32,$1                  # Start of testbinarynumeric
        leave                           # End of operatortest
        ret                             
