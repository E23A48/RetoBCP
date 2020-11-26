import { Category } from './category';

export class Notify {
    id: number;
    title: string;
    message: string;
    enabled: boolean;
    readed: boolean;
    icon_img: string;
    big_img: string;
    link_to_lunch: string;
    creadtedAt: string;
    category: Category;
}
