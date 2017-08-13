package package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightResumeSlaveInfo;
import com.ankamagames.dofus.network.types.game.action.fight.FightDispellableEffectExtendedInformations;
import com.ankamagames.dofus.network.types.game.actions.fight.GameActionMark;
import com.ankamagames.dofus.network.types.game.idol.Idol;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightSpellCooldown;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightResumeWithSlavesMessage extends GameFightResumeMessage implements INetworkMessage {

    private int protocolId = 6215;
    private boolean _isInitialized = false;
    private Vector.<GameFightResumeSlaveInfo> slavesInfo = ;
    private FuncTree _slavesInfotree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6215;
    }

    public GameFightResumeWithSlavesMessage initGameFightResumeWithSlavesMessage(Vector.<FightDispellableEffectExtendedInformations> param1,Vector.<GameActionMark>  param2,int  param3,int  param4,Vector.<Idol>  param5,Vector.<GameFightSpellCooldown>  param6,int  param7,int  param8,Vector.<GameFightResumeSlaveInfo>  param9) {
         super.initGameFightResumeMessage(param1,param2,param3,param4,param5,param6,param7,param8);
         this.slavesInfo = param9;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.slavesInfo = new Vector.<GameFightResumeSlaveInfo>();
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
         this.serializeAs_GameFightResumeWithSlavesMessage(param1);
    }

    public void serializeAs_GameFightResumeWithSlavesMessage(ICustomDataOutput param1) {
         super.serializeAs_GameFightResumeMessage(param1);
         param1.writeShort(this.slavesInfo.length);
         int _loc2_ = 0;
         while(_loc2_ < this.slavesInfo.length)
            (this.slavesInfo[_loc2_] as GameFightResumeSlaveInfo).serializeAs_GameFightResumeSlaveInfo(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightResumeWithSlavesMessage(param1);
    }

    public void deserializeAs_GameFightResumeWithSlavesMessage(ICustomDataInput param1) {
         GameFightResumeSlaveInfo _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new GameFightResumeSlaveInfo();
            _loc4_.deserialize(param1);
            this.slavesInfo.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightResumeWithSlavesMessage(param1);
    }

    public void deserializeAsyncAs_GameFightResumeWithSlavesMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._slavesInfotree = param1.addChild(this._slavesInfotreeFunc);
    }

    private void _slavesInfotreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._slavesInfotree.addChild(this._slavesInfoFunc);
            _loc3_++;
    }

    private void _slavesInfoFunc(ICustomDataInput param1) {
         GameFightResumeSlaveInfo _loc2_ = new GameFightResumeSlaveInfo();
         _loc2_.deserialize(param1);
         this.slavesInfo.push(_loc2_);
    }

}