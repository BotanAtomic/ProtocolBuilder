package package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionFightDispellEffectMessage extends GameActionFightDispellMessage implements INetworkMessage {

    private int protocolId = 6113;
    private boolean _isInitialized = false;
    private int boostUID = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6113;
    }

    public GameActionFightDispellEffectMessage initGameActionFightDispellEffectMessage(int param1,Number  param2,Number  param3,int  param4) {
         super.initGameActionFightDispellMessage(param1,param2,param3);
         this.boostUID = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.boostUID = 0;
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
         this.serializeAs_GameActionFightDispellEffectMessage(param1);
    }

    public void serializeAs_GameActionFightDispellEffectMessage(ICustomDataOutput param1) {
         super.serializeAs_GameActionFightDispellMessage(param1);
         if(this.boostUID < 0)
            throw new Exception("Forbidden value (" + this.boostUID + ") on element boostUID.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightDispellEffectMessage(param1);
    }

    public void deserializeAs_GameActionFightDispellEffectMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._boostUIDFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightDispellEffectMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightDispellEffectMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._boostUIDFunc);
    }

    private void _boostUIDFunc(ICustomDataInput param1) {
         this.boostUID = param1.readInt();
         if(this.boostUID < 0)
            throw new Exception("Forbidden value (" + this.boostUID + ") on element of GameActionFightDispellEffectMessage.boostUID.");
    }

}