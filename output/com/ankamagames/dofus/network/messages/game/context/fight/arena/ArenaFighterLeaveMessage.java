package com.ankamagames.dofus.network.messages.game.context.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterBasicMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ArenaFighterLeaveMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6700;
    private boolean _isInitialized = false;
    private CharacterBasicMinimalInformations leaver;
    private FuncTree _leavertree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6700;
    }

    public ArenaFighterLeaveMessage initArenaFighterLeaveMessage(CharacterBasicMinimalInformations param1) {
         this.leaver = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.leaver = new CharacterBasicMinimalInformations();
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
         this.serializeAs_ArenaFighterLeaveMessage(param1);
    }

    public void serializeAs_ArenaFighterLeaveMessage(ICustomDataOutput param1) {
         this.leaver.serializeAs_CharacterBasicMinimalInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ArenaFighterLeaveMessage(param1);
    }

    public void deserializeAs_ArenaFighterLeaveMessage(ICustomDataInput param1) {
         this.leaver = new CharacterBasicMinimalInformations();
         this.leaver.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ArenaFighterLeaveMessage(param1);
    }

    public void deserializeAsyncAs_ArenaFighterLeaveMessage(FuncTree param1) {
         this._leavertree = param1.addChild(this._leavertreeFunc);
    }

    private void _leavertreeFunc(ICustomDataInput param1) {
         this.leaver = new CharacterBasicMinimalInformations();
         this.leaver.deserializeAsync(this._leavertree);
    }

}