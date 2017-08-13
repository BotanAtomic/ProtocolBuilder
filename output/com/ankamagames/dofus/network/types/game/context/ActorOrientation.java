package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ActorOrientation extends Object implements INetworkType {

    private int protocolId = 353;
    private Number id = 0;
    private int direction = 1;


    public int getTypeId() {
         return 353;
    }

    public ActorOrientation initActorOrientation(Number param1,int  param2) {
         this.id = param1;
         this.direction = param2;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.direction = 1;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ActorOrientation(param1);
    }

    public void serializeAs_ActorOrientation(ICustomDataOutput param1) {
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         param1.writeByte(this.direction);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ActorOrientation(param1);
    }

    public void deserializeAs_ActorOrientation(ICustomDataInput param1) {
         this._idFunc(param1);
         this._directionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ActorOrientation(param1);
    }

    public void deserializeAsyncAs_ActorOrientation(FuncTree param1) {
         param1.addChild(this._idFunc);
         param1.addChild(this._directionFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of ActorOrientation.id.");
         }
    }

    private void _directionFunc(ICustomDataInput param1) {
         this.direction = param1.readByte();
         if(this.direction < 0)
         {
            throw new Exception("Forbidden value (" + this.direction + ") on element of ActorOrientation.direction.");
         }
    }

}