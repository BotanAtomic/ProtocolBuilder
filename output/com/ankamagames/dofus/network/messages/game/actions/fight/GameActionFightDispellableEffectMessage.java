package package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.actions.fight.AbstractFightDispellableEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GameActionFightDispellableEffectMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 6070;
    private boolean _isInitialized = false;
    private AbstractFightDispellableEffect effect = ;
    private FuncTree _effecttree = ;
    private int _loc2_ = param1.readUnsignedShort();


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6070;
    }

    public GameActionFightDispellableEffectMessage initGameActionFightDispellableEffectMessage(int param1,Number  param2,AbstractFightDispellableEffect  param3) {
         super.initAbstractGameActionMessage(param1,param2);
         this.effect = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.effect = new AbstractFightDispellableEffect();
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
         this.serializeAs_GameActionFightDispellableEffectMessage(param1);
    }

    public void serializeAs_GameActionFightDispellableEffectMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         param1.writeShort(this.effect.getTypeId());
         this.effect.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightDispellableEffectMessage(param1);
    }

    public void deserializeAs_GameActionFightDispellableEffectMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.effect = ProtocolTypeManager.getInstance(AbstractFightDispellableEffect,_loc2_);
         this.effect.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightDispellableEffectMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightDispellableEffectMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._effecttree = param1.addChild(this._effecttreeFunc);
    }

    private void _effecttreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.effect = ProtocolTypeManager.getInstance(AbstractFightDispellableEffect,_loc2_);
         this.effect.deserializeAsync(this._effecttree);
    }

}