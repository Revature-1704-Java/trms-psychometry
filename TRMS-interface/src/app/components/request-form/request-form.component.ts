import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-request-form',
  templateUrl: './request-form.component.html',
  styleUrls: ['./request-form.component.css']
})
export class RequestFormComponent implements OnInit {
  requestForm: FormGroup;
  types: Object= {
    'University Course': 1,
    'Seminar': 2,
    'Certification Prep': 3,
    'Certification': 4,
    'Technical Training': 5,
    'Other': 6
  };
  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.requestForm = this.formBuilder.group({
      event: this.formBuilder.group({
        name: ['', Validators.required],
        st_address: ['', Validators.required],
        city: ['', Validators.required],
        state: ['', Validators.required],
        zip: ['', Validators.required],
        date: ['', Validators.required],
        time: ['', Validators.required],
        work_time_loss: ['', Validators.required]
      }),
      type: ['', Validators.required],
      cost: ['', Validators.required],
      description: ['', Validators.required],
      justification: ['', Validators.required]
    });
  }
  objectKeys(obj) {
    return Object.keys(obj);
  }

}
