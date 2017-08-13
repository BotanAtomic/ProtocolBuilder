package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.MonsterBoosts;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRefreshMonsterBoostsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6618;
    private boolean _isInitialized = false;
    private Vector<MonsterBoosts> monsterBoosts;
    private Vector<MonsterBoosts> familyBoosts;
    private FuncTree _monsterBooststree;
    private FuncTree _familyBooststree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6618;
    }

    public GameRefreshMonsterBoostsMessage initGameRefreshMonsterBoostsMessage(Vector<MonsterBoosts> param1,Vector<MonsterBoosts>  param2) {
         this.monsterBoosts = param1;
         this.familyBoosts = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.monsterBoosts = new Vector.<MonsterBoosts>();
         this.familyBoosts = new Vector.<MonsterBoosts>();
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
         this.serializeAs_GameRefreshMonsterBoostsMessage(param1);
    }

    public void serializeAs_GameRefreshMonsterBoostsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.monsterBoosts.length);
         int _loc2_ = 0;
         while(_loc2_ < this.monsterBoosts.length)
         {
            (this.monsterBoosts[_loc2_] as MonsterBoosts).serializeAs_MonsterBoosts(param1);
            _loc2_++;
         }
         param1.writeShort(this.familyBoosts.length);
         int _loc3_ = 0;
         while(_loc3_ < this.familyBoosts.length)
         {
            (this.familyBoosts[_loc3_] as MonsterBoosts).serializeAs_MonsterBoosts(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRefreshMonsterBoostsMessage(param1);
    }

    public void deserializeAs_GameRefreshMonsterBoostsMessage(ICustomDataInput param1) {
         MonsterBoosts _loc6_ = null;
         MonsterBoosts _loc7_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new MonsterBoosts();
            _loc6_.deserialize(param1);
            this.monsterBoosts.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new MonsterBoosts();
            _loc7_.deserialize(param1);
            this.familyBoosts.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRefreshMonsterBoostsMessage(param1);
    }

    public void deserializeAsyncAs_GameRefreshMonsterBoostsMessage(FuncTree param1) {
         this._monsterBooststree = param1.addChild(this._monsterBooststreeFunc);
         this._familyBooststree = param1.addChild(this._familyBooststreeFunc);
    }

    private void _monsterBooststreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._monsterBooststree.addChild(this._monsterBoostsFunc);
            _loc3_++;
         }
    }

    private void _monsterBoostsFunc(ICustomDataInput param1) {
         MonsterBoosts _loc2_ = new MonsterBoosts();
         _loc2_.deserialize(param1);
         this.monsterBoosts.push(_loc2_);
    }

    private void _familyBooststreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._familyBooststree.addChild(this._familyBoostsFunc);
            _loc3_++;
         }
    }

    private void _familyBoostsFunc(ICustomDataInput param1) {
         MonsterBoosts _loc2_ = new MonsterBoosts();
         _loc2_.deserialize(param1);
         this.familyBoosts.push(_loc2_);
    }

}