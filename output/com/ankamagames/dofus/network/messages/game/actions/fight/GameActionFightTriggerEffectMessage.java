package package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightTriggerEffectMessage extends GameActionFightDispellEffectMessage implements INetworkMessage {

    private int protocolId = 6147;
    private boolean _isInitialized = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6147;
    }

    public GameActionFightTriggerEffectMessage initGameActionFightTriggerEffectMessage(int param1,Number  param2,Number  param3,int  param4) {
         super.initGameActionFightDispellEffectMessage(param1,param2,param3,param4);
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
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
         this.serializeAs_GameActionFightTriggerEffectMessage(param1);
    }

    public void serializeAs_GameActionFightTriggerEffectMessage(ICustomDataOutput param1) {
         super.serializeAs_GameActionFightDispellEffectMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightTriggerEffectMessage(param1);
    }

    public void deserializeAs_GameActionFightTriggerEffectMessage(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightTriggerEffectMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightTriggerEffectMessage(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}