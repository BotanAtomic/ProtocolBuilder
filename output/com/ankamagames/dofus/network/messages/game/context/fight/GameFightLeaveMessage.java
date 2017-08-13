package package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightLeaveMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 721;
    private boolean _isInitialized = false;
    private Number charId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 721;
    }

    public GameFightLeaveMessage initGameFightLeaveMessage(Number param1) {
         this.charId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.charId = 0;
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
         this.serializeAs_GameFightLeaveMessage(param1);
    }

    public void serializeAs_GameFightLeaveMessage(ICustomDataOutput param1) {
         if(this.charId < -9.007199254740992E15 || this.charId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.charId + ") on element charId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightLeaveMessage(param1);
    }

    public void deserializeAs_GameFightLeaveMessage(ICustomDataInput param1) {
         this._charIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightLeaveMessage(param1);
    }

    public void deserializeAsyncAs_GameFightLeaveMessage(FuncTree param1) {
         param1.addChild(this._charIdFunc);
    }

    private void _charIdFunc(ICustomDataInput param1) {
         this.charId = param1.readDouble();
         if(this.charId < -9.007199254740992E15 || this.charId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.charId + ") on element of GameFightLeaveMessage.charId.");
    }

}