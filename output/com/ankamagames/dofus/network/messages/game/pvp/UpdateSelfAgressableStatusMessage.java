package package com.ankamagames.dofus.network.messages.game.pvp;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class UpdateSelfAgressableStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6456;
    private boolean _isInitialized = false;
    private int status = 0;
    private int probationTime = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6456;
    }

    public UpdateSelfAgressableStatusMessage initUpdateSelfAgressableStatusMessage(int param1,int  param2) {
         this.status = param1;
         this.probationTime = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.status = 0;
         this.probationTime = 0;
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
         this.serializeAs_UpdateSelfAgressableStatusMessage(param1);
    }

    public void serializeAs_UpdateSelfAgressableStatusMessage(ICustomDataOutput param1) {
         param1.writeByte(this.status);
         if(this.probationTime < 0)
            throw new Exception("Forbidden value (" + this.probationTime + ") on element probationTime.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_UpdateSelfAgressableStatusMessage(param1);
    }

    public void deserializeAs_UpdateSelfAgressableStatusMessage(ICustomDataInput param1) {
         this._statusFunc(param1);
         this._probationTimeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_UpdateSelfAgressableStatusMessage(param1);
    }

    public void deserializeAsyncAs_UpdateSelfAgressableStatusMessage(FuncTree param1) {
         param1.addChild(this._statusFunc);
         param1.addChild(this._probationTimeFunc);
    }

    private void _statusFunc(ICustomDataInput param1) {
         this.status = param1.readByte();
         if(this.status < 0)
            throw new Exception("Forbidden value (" + this.status + ") on element of UpdateSelfAgressableStatusMessage.status.");
    }

    private void _probationTimeFunc(ICustomDataInput param1) {
         this.probationTime = param1.readInt();
         if(this.probationTime < 0)
            throw new Exception("Forbidden value (" + this.probationTime + ") on element of UpdateSelfAgressableStatusMessage.probationTime.");
    }

}