import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mergeArray'
})
export class MergeArrayPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
