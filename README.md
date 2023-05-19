# pic16f84-sim

FSR = File select register > is a pointer:

Addressing INDF actually addresses the register whose
address is contained in the FSR register

SFR = Special function register

W = Working register

Status = Status register

GPR = General purpose register; Directly or indirectly accessible through FSR

C = Carry > Status register
DC = Digit Carry > Status register
Z = ZeroFlag > Status register

INTCON = Interrupt Condition(?) register

SRAM in Bank1 is mappend to Bank0
