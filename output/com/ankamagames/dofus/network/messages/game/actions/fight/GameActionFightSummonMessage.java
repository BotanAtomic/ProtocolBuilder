package package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GameActionFightSummonMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 5825;
    private boolean _isInitialized = false;
    private Vector.<GameFightFighterInformations> summons = ;
    private FuncTree _summonstree = ;
    private int _loc2_ = 0;
    private GameFightFighterInformations _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private GameFightFighterInformations _loc3_ = ProtocolTypeManager.getInstance(GameFightFighterInformations,_loc2_);


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5825;
    }

    public GameActionFightSummonMessage initGameActionFightSummonMessage(int param1,Number  param2,Vector.<GameFightFighterInformations>  param3) {
         super.initAbstractGameActionMessage(param1,param2);
         this.summons = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.summons = new Vector.<GameFightFighterInformations>();
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
         this.serializeAs_GameActionFightSummonMessage(param1);
    }

    public void serializeAs_GameActionFightSummonMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         param1.writeShort(this.summons.length);
         int _loc2_ = 0;
         while(_loc2_ < this.summons.length)
            param1.writeShort((this.summons[_loc2_] as GameFightFighterInformations).getTypeId());
            (this.summons[_loc2_] as GameFightFighterInformations).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightSummonMessage(param1);
    }

    public void deserializeAs_GameActionFightSummonMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         GameFightFighterInformations _loc5_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(GameFightFighterInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.summons.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightSummonMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightSummonMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._summonstree = param1.addChild(this._summonstreeFunc);
    }

    private void _summonstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._summonstree.addChild(this._summonsFunc);
            _loc3_++;
    }

    private void _summonsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         GameFightFighterInformations _loc3_ = ProtocolTypeManager.getInstance(GameFightFighterInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.summons.push(_loc3_);
    }

}