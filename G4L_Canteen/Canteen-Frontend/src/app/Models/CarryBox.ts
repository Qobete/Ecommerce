import { Item } from './Item';
import { User } from './User';

export class CarryBox{
    boxId:number;
    // totalCost:number;
    total_cost:number;
    itemlist: Item[];
    customer: User;
}