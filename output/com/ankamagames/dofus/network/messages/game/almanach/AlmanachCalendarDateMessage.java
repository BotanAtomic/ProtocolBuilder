package com.ankamagames.dofus.network.messages.game.almanach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlmanachCalendarDateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6341;
    private boolean _isInitialized = false;
    private int date = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6341;
    }

    public AlmanachCalendarDateMessage initAlmanachCalendarDateMessage(int param1) {
         this.date = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.date = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AlmanachCalendarDateMessage(param1);
    }

    public void serializeAs_AlmanachCalendarDateMessage(ICustomDataOutput param1) {
         param1.writeInt(this.date);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AlmanachCalendarDateMessage(param1);
    }

    public void deserializeAs_AlmanachCalendarDateMessage(ICustomDataInput param1) {
         this._dateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AlmanachCalendarDateMessage(param1);
    }

    public void deserializeAsyncAs_AlmanachCalendarDateMessage(FuncTree param1) {
         param1.addChild(this._dateFunc);
    }

    private void _dateFunc(ICustomDataInput param1) {
         this.date = param1.readInt();
    }

}