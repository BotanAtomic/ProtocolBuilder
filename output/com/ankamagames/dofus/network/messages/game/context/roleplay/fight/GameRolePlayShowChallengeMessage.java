package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightCommonInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayShowChallengeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 301;
    private boolean _isInitialized = false;
    private FightCommonInformations commonsInfos;
    private FuncTree _commonsInfostree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 301;
    }

    public GameRolePlayShowChallengeMessage initGameRolePlayShowChallengeMessage(FightCommonInformations param1) {
         this.commonsInfos = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.commonsInfos = new FightCommonInformations();
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
         this.serializeAs_GameRolePlayShowChallengeMessage(param1);
    }

    public void serializeAs_GameRolePlayShowChallengeMessage(ICustomDataOutput param1) {
         this.commonsInfos.serializeAs_FightCommonInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayShowChallengeMessage(param1);
    }

    public void deserializeAs_GameRolePlayShowChallengeMessage(ICustomDataInput param1) {
         this.commonsInfos = new FightCommonInformations();
         this.commonsInfos.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayShowChallengeMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayShowChallengeMessage(FuncTree param1) {
         this._commonsInfostree = param1.addChild(this._commonsInfostreeFunc);
    }

    private void _commonsInfostreeFunc(ICustomDataInput param1) {
         this.commonsInfos = new FightCommonInformations();
         this.commonsInfos.deserializeAsync(this._commonsInfostree);
    }

}