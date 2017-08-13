package com.ankamagames.dofus.network.messages.game.atlas.compass;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.MapCoordinates;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CompassUpdatePvpSeekMessage extends CompassUpdateMessage implements INetworkMessage {

    private int protocolId = 6013;
    private boolean _isInitialized = false;
    private Number memberId = 0;
    private String memberName = "";


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6013;
    }

    public CompassUpdatePvpSeekMessage initCompassUpdatePvpSeekMessage(int param1,MapCoordinates  param2,Number  param3,String  param4) {
         super.initCompassUpdateMessage(param1,param2);
         this.memberId = param3;
         this.memberName = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.memberId = 0;
         this.memberName = "";
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
         this.serializeAs_CompassUpdatePvpSeekMessage(param1);
    }

    public void serializeAs_CompassUpdatePvpSeekMessage(ICustomDataOutput param1) {
         super.serializeAs_CompassUpdateMessage(param1);
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
         }
         param1.writeVarLong(this.memberId);
         param1.writeUTF(this.memberName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CompassUpdatePvpSeekMessage(param1);
    }

    public void deserializeAs_CompassUpdatePvpSeekMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._memberIdFunc(param1);
         this._memberNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CompassUpdatePvpSeekMessage(param1);
    }

    public void deserializeAsyncAs_CompassUpdatePvpSeekMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._memberIdFunc);
         param1.addChild(this._memberNameFunc);
    }

    private void _memberIdFunc(ICustomDataInput param1) {
         this.memberId = param1.readVarUhLong();
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element of CompassUpdatePvpSeekMessage.memberId.");
         }
    }

    private void _memberNameFunc(ICustomDataInput param1) {
         this.memberName = param1.readUTF();
    }

}