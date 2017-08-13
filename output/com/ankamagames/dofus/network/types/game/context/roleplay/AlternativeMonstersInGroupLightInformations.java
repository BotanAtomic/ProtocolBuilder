package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlternativeMonstersInGroupLightInformations extends Object implements INetworkType {

    private int protocolId = 394;
    private int playerCount = 0;
    private MonsterInGroupLightInformations[] monsters;
    private FuncTree _monsterstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.playerCount);
         param1.writeShort(this.monsters.length);
         int _loc2_ = 0;
         while(_loc2_ < this.monsters.length)
         {
            (this.monsters[_loc2_] as MonsterInGroupLightInformations).serializeAs_MonsterInGroupLightInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         MonsterInGroupLightInformations _loc4_ = null;
         this.playerCount = param1.readInt();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new MonsterInGroupLightInformations();
            _loc4_.deserialize(param1);
            this.monsters.push(_loc4_);
            _loc3_++;
         }
    }

}