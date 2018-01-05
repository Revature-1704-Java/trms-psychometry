import { Reimbursement } from '../class/Reimbursement';

export interface User {
    e_id: number;
    employee_type: number;
    firstName: String;
    lastName: String;
    Reimbursements: Reimbursement[];
}
